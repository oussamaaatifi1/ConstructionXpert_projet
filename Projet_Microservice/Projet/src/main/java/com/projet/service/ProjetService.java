package com.projet.service;

import com.projet.model.Projet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {

    public Projet ajouterProjet(Projet projet);
    public Projet modifierProjet(Long id, Projet projet);
    public List<Projet> allProjets();
//    public void supprimerProjet(Long id);
//    public FullProjetResponse projetWithTaches(Long id);
}
