package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Aeroport;
import Mp.example.demoM.Entities.Avion;
import Mp.example.demoM.repositories.AeroportRepository;
import Mp.example.demoM.repositories.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    public class AvionInitializer implements CommandLineRunner {

        @Autowired
        private AvionRepository avionRepository;

        @Autowired
        private AeroportRepository aeroportRepository;

        @Override
        public void run(String... args) throws Exception {
            // Vérifiez si des avions existent déjà
            if (avionRepository.count() == 0) {
                // Récupérer tous les aéroports existants dans la base
                List<Aeroport> aeroports = aeroportRepository.findAll();

                // Création des avions
                Avion avion1 = new Avion(null, "Boeing 737", 200, "2015", "737-800");
                Avion avion2 = new Avion(null, "Airbus A320", 180, "2017", "A320neo");

                // Associer les aéroports existants aux avions
                if (!aeroports.isEmpty()) {
                    avion1.setAeroports(aeroports);  // Associer à tous les aéroports
                    avion2.setAeroports(aeroports.subList(0, 1));  // Associer à un seul aéroport (exemple)
                }

                // Sauvegarder les avions
                avionRepository.saveAll(List.of(avion1, avion2));

                System.out.println("Avions créés avec succès !");
            } else {
                System.out.println("Les données des avions existent déjà dans la base.");
            }
        }

}
