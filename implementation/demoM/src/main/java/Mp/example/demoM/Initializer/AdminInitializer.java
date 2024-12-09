package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Admin;
import Mp.example.demoM.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder; // Injection du PasswordEncoder


    @Override
    public void run(String... args) throws Exception {
        // Vérifier si un administrateur par défaut n'existe pas
        if (!adminRepository.existsByEmail("admin@aviation.com")) {
            Admin admin = new Admin();
            admin.setEmail("admin@aviation.com");
            admin.setPassword(passwordEncoder.encode("securepassword")); // Hachage du mot de passe
            admin.setNomComplet("Admin Aviation");
            adminRepository.save(admin);
        }

        // Ajouter d'autres administrateurs si nécessaire
        if (!adminRepository.existsByEmail("superadmin@aviation.com")) {
            Admin superAdmin = new Admin();
            superAdmin.setEmail("superadmin@aviation.com");
            superAdmin.setPassword(passwordEncoder.encode("supersecurepassword")); // Hachage du mot de passe
            superAdmin.setNomComplet("Super Admin");
            adminRepository.save(superAdmin);
        }
    }
}
