package Mp.example.demoM.Initializer;

import Mp.example.demoM.Entities.Paiement;
import Mp.example.demoM.Entities.Passager;
import Mp.example.demoM.Entities.Reservation;
import Mp.example.demoM.Entities.Vol;
import Mp.example.demoM.repositories.PaimentRepository;
import Mp.example.demoM.repositories.PassagerRepo;
import Mp.example.demoM.repositories.ReservationRepo;
import Mp.example.demoM.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ReservationInitializer implements CommandLineRunner {

    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private PassagerRepo passagerRepository;

    @Autowired
    private VolRepository volRepository;

    @Autowired
    private PaimentRepository paiementRepository;

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si des réservations existent déjà
        if (reservationRepository.count() == 0) {
            // Récupérer un passager et un vol existants
            Passager passager = passagerRepository.findById(1L).orElse(null); // Exemple avec un passager ayant l'ID 1
            Vol vol = volRepository.findById(1L).orElse(null); // Exemple avec un vol ayant l'ID 1
            if (passager != null && vol != null) {
                // Créer une réservation avec des données par défaut
                Reservation reservation1 = new Reservation();
                reservation1.setVolReserve(vol);
                reservation1.setPassagerReservant(passager);
                reservation1.setDateReservation("2024-12-15");
                reservation1.setStatus("Confirmée");
                reservation1.setPrixTotal(500.0);

                // Créer un paiement associé à la réservation
                Paiement paiement = new Paiement(null, "123456789", "Carte Bancaire", 250.0, "Valide");
                paiement.setMontant(500.0);
                paiement.setDatePaiement("2024-12-15");
                paiement.setReservation(reservation1);

                // Sauvegarder le paiement
                paiementRepository.save(paiement);

                // Sauvegarder la réservation
                reservationRepository.save(reservation1);

                System.out.println("Réservation créée avec succès !");
            } else {
                System.out.println("Passager ou vol non trouvé.");
            }
        } else {
            System.out.println("Les réservations existent déjà dans la base.");
        }

    }
}