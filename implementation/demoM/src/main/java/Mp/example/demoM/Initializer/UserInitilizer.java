package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.User;
import Mp.example.demoM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitilizer  implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si l'utilisateur par défaut n'existe pas
        if (!userRepository.existsByEmail("admin@example.com")) {
            User adminUser = new User();
            adminUser.setEmail("admin@example.com");
            adminUser.setPassword("securepassword"); // Remplacez par un mot de passe haché dans un contexte réel
            adminUser.setNomComplet("Administrateur");
            userRepository.save(adminUser);
        }

        if (!userRepository.existsByEmail("user@example.com")) {
            User normalUser = new User();
            normalUser.setEmail("user@example.com");
            normalUser.setPassword("userpassword"); // Remplacez par un mot de passe haché
            normalUser.setNomComplet("Utilisateur Normal");
            userRepository.save(normalUser);
        }
    }
}
