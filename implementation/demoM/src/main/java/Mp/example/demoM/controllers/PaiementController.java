package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Paiement;
import Mp.example.demoM.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    // Ajouter un paiement
    @PostMapping
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        Paiement newPaiement = paiementService.addPaiement(paiement);
        return ResponseEntity.ok(newPaiement);
    }

    // Récupérer tous les paiements
    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    // Récupérer un paiement par ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paiement>> getPaiementById(@PathVariable Long id) {
        Optional<Paiement> paiement = paiementService.getPaiementById(id);
        if (paiement != null) {
            return ResponseEntity.ok(paiement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour un paiement
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement updatedPaiement) {
        Paiement paiement = paiementService.updatePaiement(id, updatedPaiement);
        if (paiement != null) {
            return ResponseEntity.ok(paiement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un paiement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        boolean isDeleted = paiementService.deletePaiement(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

