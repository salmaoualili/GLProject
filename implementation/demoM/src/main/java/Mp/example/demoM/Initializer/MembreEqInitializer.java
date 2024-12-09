package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Admin;
import Mp.example.demoM.Entities.MembreEquipage;
import Mp.example.demoM.repositories.AdminRepository;
import Mp.example.demoM.repositories.MembreEquRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MembreEqInitializer implements CommandLineRunner {
    @Autowired
    private MembreEquRepository membreEquipageRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si des membres d'équipage existent déjà
        if (membreEquipageRepository.count() == 0) {
            // Récupérer l'administrateur pour assigner les membres à un administrateur
            Optional<Admin> admin = adminRepository.findByEmail("admin@aviation.com");

            if (admin.isPresent()) {
                // Création des membres d'équipage
                MembreEquipage membre1 = new MembreEquipage(null, "John Doe", "Pilote", "12345", "Française", "Option A");
                MembreEquipage membre2 = new MembreEquipage(null, "Jane Smith", "Co-pilote", "67890", "Américaine", "Option B");

                // Associer ces membres à l'administrateur
                membre1.setAdmin(admin.orElse(null));
                membre2.setAdmin(admin.orElse(null));

                // Sauvegarder les membres d'équipage
                membreEquipageRepository.saveAll(List.of(membre1, membre2));

                System.out.println("Membres d'équipage créés avec succès !");
            } else {
                System.out.println("L'administrateur spécifié n'existe pas.");
                System.out.println("L'administrateur spécifié n'existe pas.");
            }
        } else {
            System.out.println("Les membres d'équipage existent déjà dans la base.");
        }
}

}
