package com.projet.service;

import com.projet.dto.ProjetDTO;
import com.projet.model.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {

    public Projet modifierProjet(Long id, ProjetDTO projetDTO);
    public List<ProjetDTO> allProjets();
    public Projet ajouterProjet(ProjetDTO projetDTO);
    public void supprimerProjet(Long id);

}
