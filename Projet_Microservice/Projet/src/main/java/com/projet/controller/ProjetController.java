package com.projet.controller;

import com.projet.model.Projet;
import com.projet.service.impl.ProjetServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Projet/")
public class ProjetController {
    @Autowired
    ProjetServiceImpl ProjetService;

    @PostMapping("add")
    public Projet addProjet(@RequestBody Projet Projet){
        return ProjetService.ajouterProjet(Projet);
    }

    @GetMapping("all")
    public List<Projet> getAll(){
        return ProjetService.allProjets();
    }

//    @GetMapping("{id}")
//    public FullProjetResponse projetWithTaches(@PathVariable Long id){
//        return ProjetService.projetWithTaches(id);
//    }

    @PutMapping("edit/{id}")
    public Projet edit(@PathVariable Long id, @RequestBody Projet Projet){
        return ProjetService.modifierProjet(id, Projet);
    }

//    @DeleteMapping("delete/{id}")
//    public void delete(@PathVariable Long id){
//        ProjetService.supprimerProjet(id);
//    }
}

