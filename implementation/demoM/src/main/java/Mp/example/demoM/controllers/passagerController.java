package Mp.example.demoM.controllers;

import Mp.example.demoM.Entities.Passager;
import Mp.example.demoM.payload.Request.SignupRequest;
import Mp.example.demoM.services.passagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class passagerController {
    @Autowired
    private passagerService passagerService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerPassager(@RequestBody SignupRequest signupRequest) {
        if (passagerService.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        Passager passager = new Passager();
        passager.setemail(signupRequest.getEmail());
        passager.setpassword(signupRequest.getPassword());
        passager.setnomComplet(signupRequest.getNomComplet());
        passager.setNumPasseport(signupRequest.getNumPasseport());
        passager.setNumCarteIdentite(signupRequest.getNumCarteIdentite());
        passager.setNationalite(signupRequest.getNationalite());
        passager.setAdresse(signupRequest.getAdresse());
        passager.setTelephone(signupRequest.getTelephone());

        passagerService.savePassager(passager);

        return ResponseEntity.ok("Passager registered successfully!");
    }

    // Exemple d'autres fonctionnalités pour Passager
    @GetMapping("/{id}")
    public ResponseEntity<?> getPassagerById(@PathVariable Long id_passager) {
        Passager passager = passagerService.findByid_passager(id_passager);
        if (passager == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passager);
    }
}
