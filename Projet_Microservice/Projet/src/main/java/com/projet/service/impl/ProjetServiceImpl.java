package com.projet.service.impl;


import com.projet.config.TachesClient;
import com.projet.model.Projet;
import com.projet.repository.ProjetRepository;
import com.projet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjetServiceImpl implements ProjetService{

    @Autowired
    ProjetRepository projetsRepository;
//    @Autowired
//    TachesClient tachesClient;

    @Override
    public Projet ajouterProjet(Projet projet) {
        return projetsRepository.save(projet);
    }

    @Override
    public Projet modifierProjet(Long id, Projet projet) {
        Projet edited = new Projet();
        edited.setId(id);
        edited.setName(projet.getName());
        edited.setDescription(projet.getDescription());
        edited.setBudget(projet.getBudget());
        edited.setStartDate(projet.getStartDate());
        edited.setEndDate(projet.getEndDate());
        return projetsRepository.save(edited);
    }

    @Override
    public List<Projet> allProjets() {
        return projetsRepository.findAll();
    }

//    @Override
//    public void supprimerProjet(Long id) {
//        tachesClient.deleteTacheWithProjet(id);
//        projetsRepository.deleteById(id);
//    }

//    @Override
//    public FullProjetResponse projetWithTaches(Long id) {
//        Projet projet = projetsRepository.findById(id)
//                .orElse(
//                        Projet.builder()
//                                .nom("NOT_FOUND")
//                                .build()
//                );
//        List<Taches> taches = tachesClient.findAllTachesByProjet(id);
//        return FullProjetResponse.builder()
//                .nom(projet.getNom())
//                .dateDebut(projet.getDateDebut())
//                .dateFin(projet.getDateFin())
//                .description(projet.getDescription())
//                .budget(projet.getBudget())
//                .taches(taches)
//                .build();
//    }
}