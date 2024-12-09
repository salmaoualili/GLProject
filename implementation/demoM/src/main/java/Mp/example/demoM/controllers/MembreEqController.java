package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.MembreEquipage;
import Mp.example.demoM.services.MembreEquipageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class MembreEqController {
    @Autowired
    private MembreEquipageService membreEquipageService;

    // Obtenir tous les membres d'équipage
    @GetMapping
    public ResponseEntity<List<MembreEquipage>> getAllMembresEquipage() {
        List<MembreEquipage> membres = membreEquipageService.getAllMembresEquipage();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    // Obtenir un membre d'équipage par ID
    @GetMapping("/{id}")
    public ResponseEntity<MembreEquipage> getMembreEquipageById(@PathVariable Long id) {
        Optional<MembreEquipage> membre = membreEquipageService.getMembreEquipageById(id);
        return membre.map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Créer un nouveau membre d'équipage
    @PostMapping
    public ResponseEntity<MembreEquipage> createMembreEquipage(@RequestBody MembreEquipage membreEquipage) {
        MembreEquipage createdMembre = membreEquipageService.createMembreEquipage(membreEquipage);
        return new ResponseEntity<>(createdMembre, HttpStatus.CREATED);
    }
    // Mettre à jour un membre d'équipage existant
    @PutMapping("/{id}")
    public ResponseEntity<MembreEquipage> updateMembreEquipage(@PathVariable Long id, @RequestBody MembreEquipage membreEquipage) {
        Optional<MembreEquipage> existingMembre = membreEquipageService.getMembreEquipageById(id);
        if (existingMembre.isPresent()) {
            MembreEquipage updatedMembre = membreEquipageService.updateMembreEquipage(id, membreEquipage);
            return new ResponseEntity<>(updatedMembre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un membre d'équipage
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembreEquipage(@PathVariable Long id) {
        Optional<MembreEquipage> existingMembre = membreEquipageService.getMembreEquipageById(id);
        if (existingMembre.isPresent()) {
            membreEquipageService.deleteMembreEquipage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
