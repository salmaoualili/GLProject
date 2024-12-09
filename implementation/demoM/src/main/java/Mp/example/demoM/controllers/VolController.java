package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Vol;
import Mp.example.demoM.services.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class VolController {
    @Autowired
    private VolService volService;

    // Ajouter un vol
    @PostMapping
    public ResponseEntity<Vol> createVol(@RequestBody Vol vol) {
        Vol newVol = volService.addVol(vol);
        return ResponseEntity.ok(newVol);
    }

    // Récupérer tous les vols
    @GetMapping
    public ResponseEntity<List<Vol>> getAllVols() {
        List<Vol> vols = volService.getAllVols();
        return ResponseEntity.ok(vols);
    }

    // Récupérer un vol par ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vol>> getVolById(@PathVariable Long id) {
        Optional<Vol> vol = volService.getVolById(id);
        if (vol.isPresent()) {
            return ResponseEntity.ok(vol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Mettre à jour un vol
    @PutMapping("/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable Long id, @RequestBody Vol updatedVol) {
        Vol vol = volService.updateVol(id, updatedVol);
        if (vol != null) {
            return ResponseEntity.ok(vol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un vol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVol(@PathVariable Long id) {
        boolean isDeleted = volService.deleteVol(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

