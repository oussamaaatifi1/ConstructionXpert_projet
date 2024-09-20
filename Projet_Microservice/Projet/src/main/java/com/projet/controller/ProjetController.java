package com.projet.controller;

import com.projet.dto.ProjetDTO;
import com.projet.model.Projet;
import com.projet.service.impl.ProjetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projet")
public class ProjetController {

    @Autowired
    private ProjetServiceImpl projetService;

    @PostMapping("/add")
    public ResponseEntity<Projet> addProjet(@RequestBody ProjetDTO projetDTO) {
        Projet projet = projetService.ajouterProjet(projetDTO);
        return ResponseEntity.ok(projet);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjetDTO>> getAll() {
        List<ProjetDTO> projets = projetService.allProjets();
        return ResponseEntity.ok(projets);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Projet> edit(@PathVariable Long id, @RequestBody ProjetDTO projetDTO) {
        Projet projet = projetService.modifierProjet(id, projetDTO);
        return ResponseEntity.ok(projet);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetService.supprimerProjet(id);
        return ResponseEntity.noContent().build();
    }

}
