package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Aeroport;
import Mp.example.demoM.repositories.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AeroportInitializer implements CommandLineRunner {

    @Autowired
    private AeroportRepository aeroportRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifiez si des aéroports existent déjà dans la base de données
        if (aeroportRepository.count() == 0) {
            // Créez et enregistrez quelques aéroports pour initialiser les données
            Aeroport aeroport1 = new Aeroport(null, "CDG", "Aéroport Charles de Gaulle", "Paris", "France", 1000000);
            Aeroport aeroport2 = new Aeroport(null, "JFK", "John F. Kennedy International Airport", "New York", "USA", 900000);
            Aeroport aeroport3 = new Aeroport(null, "DXB", "Dubai International Airport", "Dubai", "UAE", 1200000);

            aeroportRepository.save(aeroport1);
            aeroportRepository.save(aeroport2);
            aeroportRepository.save(aeroport3);

            System.out.println("Aéroports initialisés dans la base de données.");
        } else {
            System.out.println("Les aéroports existent déjà dans la base de données.");
        }
    }
}
