package ressourceservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ressourceservice.dto.RessourceDTO;
import ressourceservice.service.RessourceService;

import java.util.List;

@RestController
@RequestMapping("/ressources")
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;

    @PostMapping("/add/{idTache}")
    public ResponseEntity<String> ajouterRessource(@RequestBody RessourceDTO ressourceDTO, @PathVariable int idTache) {
        try {
            ressourceService.addRessource(ressourceDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Resource created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating resource: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<RessourceDTO>> getAllRessources() {
        List<RessourceDTO> ressources = ressourceService.getAllRessources();
        return ResponseEntity.ok(ressources);
    }

    @GetMapping("/{idRessource}")
    public ResponseEntity<RessourceDTO> getRessourceById(@PathVariable int idRessource) {
        try {
            RessourceDTO ressource = ressourceService.getRessourceById(idRessource);
            return ResponseEntity.ok(ressource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/tache/{idTache}")
    public ResponseEntity<List<RessourceDTO>> getRessourcesByTache(@PathVariable int idTache) {
        List<RessourceDTO> ressources = ressourceService.getRessourcesByTache(idTache);
        return ResponseEntity.ok(ressources);
    }

    @PutMapping("/update/{idRessource}")
    public ResponseEntity<String> modifierRessource(@PathVariable int idRessource, @RequestBody RessourceDTO ressourceDTO) {
        try {
            ressourceService.updateRessource(idRessource, ressourceDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Resource updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error updating resource: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idRessource}")
    public ResponseEntity<String> supprimerRessource(@PathVariable int idRessource) {
        try {
            ressourceService.deleteRessource(idRessource);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Resource deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting resource: " + e.getMessage());
        }
    }
}

