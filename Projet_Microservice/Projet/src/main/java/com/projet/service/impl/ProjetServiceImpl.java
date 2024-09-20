package com.projet.service.impl;

import com.projet.dto.ProjetDTO;
import com.projet.mapper.ProjetMapper;
import com.projet.model.Projet;
import com.projet.repository.ProjetRepository;
import com.projet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetsRepository;

    @Autowired
    private ProjetMapper projetMapper;

    @Override
    public Projet ajouterProjet(ProjetDTO projetDTO) {
        Projet projet = projetMapper.toEntity(projetDTO);
        return projetsRepository.save(projet);
    }

    @Override
    public Projet modifierProjet(Long id, ProjetDTO projetDTO) {
        Projet existingProjet = projetsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet not found"));
        existingProjet.setName(projetDTO.getName());
        existingProjet.setDescription(projetDTO.getDescription());
        existingProjet.setBudget(projetDTO.getBudget());
        existingProjet.setStartDate(projetDTO.getStartDate());
        existingProjet.setEndDate(projetDTO.getEndDate());
        return projetsRepository.save(existingProjet);
    }

    @Override
    public List<ProjetDTO> allProjets() {
        List<Projet> projets = projetsRepository.findAll();
        return projets.stream()
                .map(projetMapper::toDto)
                .toList();
    }

    @Override
    public void supprimerProjet(Long id) {
        projetsRepository.deleteById(id);
    }


}
