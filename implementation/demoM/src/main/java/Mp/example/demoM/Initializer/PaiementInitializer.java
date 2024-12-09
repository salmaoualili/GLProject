package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Paiement;
import Mp.example.demoM.repositories.PaimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PaiementInitializer implements CommandLineRunner {
    @Autowired
    private PaimentRepository paiementRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifiez si des paiements existent déjà dans la base de données
        if (paiementRepository.count() == 0) {
            // Créez et enregistrez quelques paiements pour initialiser les données
            Paiement paiement1 = new Paiement(null, "123456789", "Carte Bancaire", 250.0, "Valide");
            Paiement paiement2 = new Paiement(null, "987654321", "PayPal", 150.5, "En attente");
            Paiement paiement3 = new Paiement(null, "456789123", "Virement Bancaire", 300.0, "Refusé");

            paiementRepository.save(paiement1);
            paiementRepository.save(paiement2);
            paiementRepository.save(paiement3);

            System.out.println("Paiements initialisés dans la base de données.");
        } else {
            System.out.println("Les paiements existent déjà dans la base de données.");
        }
    }
}
