package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Paiement;
import Mp.example.demoM.repositories.PaimentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PaiementService {
    @Autowired // Injecte automatiquement PaiementRepository
    private PaimentRepository paiementRepository;

    // Méthode pour récupérer tous les paiements
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll(); // Retourne tous les paiements
    }

    // Méthode pour récupérer un paiement par ID
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id); // Cherche un paiement par son ID
    }

    // Méthode pour sauvegarder un nouveau paiement
    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement); // Enregistre le paiement dans la base de données
    }

    // Méthode pour mettre à jour un paiement existant
    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        return paiementRepository.findById(id) // Cherche un paiement par son ID
                .map((Paiement paiement) -> {
                    paiement.setReservation(paiementDetails.getReservation()); // Met à jour la réservation associée
                    return paiementRepository.save(paiement); // Sauvegarde les modifications
                })
                .orElseThrow(() ->
                        new RuntimeException("Paiement not found with id " + id)); // Erreur si le paiement n'existe pas
    }

    // Méthode pour supprimer un paiement par son ID
    public boolean deletePaiement(Long id) {
        paiementRepository.deleteById(id); // Supprime le paiement
        return false;
    }
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
}

    }
