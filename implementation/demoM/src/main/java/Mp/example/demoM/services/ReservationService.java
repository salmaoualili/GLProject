package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Reservation;
import Mp.example.demoM.repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReservationService {
    @Autowired // Injecte automatiquement l'instance de ReservationRepository
    private ReservationRepo reservationRepository;

    // Méthode pour récupérer toutes les réservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll(); // Retourne toutes les réservations depuis la base
    }

    // Méthode pour récupérer une réservation par son ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id); // Recherche une réservation par son ID
    }

    // Méthode pour créer une nouvelle réservation
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation); // Enregistre une réservation dans la base
    }

    // Méthode pour mettre à jour une réservation existante
    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        return reservationRepository.findById(id) // Recherche la réservation par ID
                .map(reservation -> {
                    reservation.setVolReserve(reservationDetails.getVolReserve()); // Met à jour le vol réservé
                    reservation.setPassagerReservant(reservationDetails.getPassagerReservant());
                    // Met à jour le passager réservant
                    reservation.setDateReservation(reservationDetails.getDateReservation()); // Met à jour la date de réservation
                    reservation.setStatus(reservationDetails.getStatus()); // Met à jour le statut
                    reservation.setPrixTotal(reservationDetails.getPrixTotal()); // Met à jour le prix total
                    return reservationRepository.save(reservation); // Enregistre les changements
                })
                .orElseThrow(() ->
                        new RuntimeException("Reservation not found with id " + id)); // Lance une exception si non trouvée
    }

    // Méthode pour supprimer une réservation par son ID
    public boolean deleteReservation(Long id) {
        reservationRepository.deleteById(id); // Supprime la réservation dans la base
        return false;
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
