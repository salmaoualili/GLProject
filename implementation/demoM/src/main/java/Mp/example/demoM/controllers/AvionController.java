package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Avion;
import Mp.example.demoM.services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AvionController {
    @Autowired
    private AvionService avionService;

    // Récupérer tous les avions
    @GetMapping
    public List<Avion> getAllAvions() {
        return avionService.getAllAvions();
    }

    // Récupérer un avion par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Avion> getAvionById(@PathVariable Long id) {
        Optional<Avion> avion = avionService.getAvionById(id);
        return avion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouvel avion
    @PostMapping
    public Avion createAvion(@RequestBody Avion avion) {
        return avionService.saveAvion(avion);
    }

    // Mettre à jour un avion existant
    @PutMapping("/{id}")
    public ResponseEntity<Avion> updateAvion(@PathVariable Long id, @RequestBody Avion avionDetails) {
        try {
            Avion updatedAvion = avionService.updateAvion(id, avionDetails);
            return ResponseEntity.ok(updatedAvion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un avion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvion(@PathVariable Long id) {
        try {
            avionService.deleteAvion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
