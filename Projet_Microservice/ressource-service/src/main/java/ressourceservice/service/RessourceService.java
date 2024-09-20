package ressourceservice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ressourceservice.dto.RessourceDTO;
import ressourceservice.exception.RessourceNotFoundException;
import ressourceservice.mapper.RessourceMapper;
import ressourceservice.model.Ressource;
import ressourceservice.repository.RessourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RessourceMapper ressourceMapper;

    public RessourceDTO addRessource(RessourceDTO ressourceDTO) {
        Ressource ressource = ressourceMapper.toEntity(ressourceDTO);
        Ressource savedRessource = ressourceRepository.save(ressource);
        return ressourceMapper.toDto(savedRessource);
    }

    public RessourceDTO getRessourceById(int idRessource) {
        Ressource ressource = ressourceRepository
                .findById((long) idRessource)
                .orElseThrow(RessourceNotFoundException::new);
        return ressourceMapper.toDto(ressource);
    }

    public List<RessourceDTO> getAllRessources() {
        List<Ressource> ressources = ressourceRepository.findAll();
        return ressources.stream()
                .map(ressourceMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RessourceDTO> getRessourcesByTache(int idTache) {
        List<Ressource> ressources = ressourceRepository.findByIdTache(idTache);
        return ressources.stream()
                .map(ressourceMapper::toDto)
                .collect(Collectors.toList());
    }

    public RessourceDTO updateRessource(int idRessource, RessourceDTO ressourceDTO) {
        Ressource existingRessource = ressourceRepository
                .findById((long) idRessource)
                .orElseThrow(RessourceNotFoundException::new);

        Ressource updatedRessource = ressourceMapper.toEntity(ressourceDTO);
        updatedRessource.setIdRessource(idRessource); // To ensure the same ID
        Ressource savedRessource = ressourceRepository.save(updatedRessource);
        return ressourceMapper.toDto(savedRessource);
    }

    public void deleteRessource(int idRessource) {
        Ressource ressource = ressourceRepository
                .findById((long) idRessource)
                .orElseThrow(RessourceNotFoundException::new);
        ressourceRepository.delete(ressource);
    }
}
