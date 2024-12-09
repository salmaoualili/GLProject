package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Passager;
import Mp.example.demoM.repositories.PassagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class passagerService {
    @Autowired // Injection automatique du PassagerRepository
    private PassagerRepo passagerRepository;

    // Méthode pour récupérer tous les passagers
    public List<Passager> getAllPassagers() {
        return passagerRepository.findAll(); // Récupère tous les passagers de la base de données
    }

    // Méthode pour récupérer un passager par ID
    public Optional<Passager> getPassagerById(Long id) {
        return passagerRepository.findById(id); // Cherche un passager par son ID
    }

    // Méthode pour ajouter un nouveau passager
    public Passager savePassager(Passager passager) {
        return passagerRepository.save(passager); // Enregistre un nouveau passager dans la base de données
    }
    public Passager updatePassager(Long id, Passager passagerDetails) {
        return passagerRepository.findById(id) // Cherche un passager par son ID
                .map(passager -> {
                    passager.setNumPasseport(passagerDetails.getNumPasseport()); // Met à jour le numéro de passeport
                    passager.setNumCarteIdentite(passagerDetails.getNumCarteIdentite()); // Met à jour la carte d'identité
                    passager.setNationalite(passagerDetails.getNationalite()); // Met à jour la nationalité
                    passager.setAdresse(passagerDetails.getAdresse()); // Met à jour l'adresse
                    passager.setTelephone(passagerDetails.getTelephone()); // Met à jour le numéro de téléphone
                    return passagerRepository.save(passager); // Enregistre les modifications
                })
                .orElseThrow(() ->
                        new RuntimeException("Passager not found with id " + id)); // Lance une erreur si le passager n'existe pas
    }

    // Méthode pour supprimer un passager par son ID
    public void deletePassager(Long id) {
        passagerRepository.deleteById(id); // Supprime un passager de la base de données
}

    public boolean existsByEmail(String email) {
        return passagerRepository.existsByEmail(email);
    }



    public Passager findByid_passager(Long idPassager) {
        return null;
    }
}
