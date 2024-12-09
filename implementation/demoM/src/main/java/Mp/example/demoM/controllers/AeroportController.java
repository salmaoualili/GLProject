package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Aeroport;
import Mp.example.demoM.services.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AeroportController {
    @Autowired
    private AeroportService aeroportService;

    // Endpoint pour obtenir tous les aéroports
    @GetMapping
    public ResponseEntity<List<Aeroport>> getAllAeroports() {
        List<Aeroport> aeroports = aeroportService.getAllAeroports();
        return new ResponseEntity<>(aeroports, HttpStatus.OK);
    }

    // Endpoint pour obtenir un aéroport par ID
    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable Long id) {
        Optional<Aeroport> aeroport = aeroportService.getAeroportById(id);
        return aeroport.map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour créer un nouvel aéroport
    @PostMapping
    public ResponseEntity<Aeroport> createAeroport(@RequestBody Aeroport aeroport) {
        Aeroport createdAeroport = aeroportService.createAeroport(aeroport);
        return new ResponseEntity<>(createdAeroport, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un aéroport existant
    @PutMapping("/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable Long id, @RequestBody Aeroport aeroport) {
        Optional<Aeroport> existingAeroport = aeroportService.getAeroportById(id);
        if (existingAeroport.isPresent()) {
            Aeroport updatedAeroport = aeroportService.updateAeroport(id, aeroport);
            return new ResponseEntity<>(updatedAeroport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un aéroport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable Long id) {
        Optional<Aeroport> existingAeroport = aeroportService.getAeroportById(id);
        if (existingAeroport.isPresent()) {
            aeroportService.deleteAeroport(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
}

}
