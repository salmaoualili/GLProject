package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Vol;
import Mp.example.demoM.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VolService {
    @Autowired // Injecte automatiquement l'instance de VolRepository
    private VolRepository volRepository;

    // Méthode pour récupérer tous les vols
    public List<Vol> getAllVols() {
        return volRepository.findAll(); // Retourne tous les vols depuis la base
    }

    // Méthode pour récupérer un vol par son ID
    public Optional<Vol> getVolById(Long id) {
        return volRepository.findById(id); // Recherche un vol par son ID
    }

    // Méthode pour créer un nouveau vol
    public Vol saveVol(Vol vol) {
        return volRepository.save(vol); // Enregistre un vol dans la base
    }

    // Méthode pour mettre à jour un vol existant
    public Vol updateVol(Long id, Vol volDetails) {
        return volRepository.findById(id) // Recherche le vol par ID
                .map(vol -> {
                    vol.setNumVol(volDetails.getNumVol()); // Met à jour le numéro de vol
                    vol.setVolIATA(volDetails.getVolIATA()); // Met à jour le code IATA
                    vol.setDateVol(volDetails.getDateVol()); // Met à jour la date du vol
                    vol.setAeroportDepart(volDetails.getAeroportDepart()); // Met à jour l'aéroport de départ
                    vol.setAeroportArrive(volDetails.getAeroportArrive()); // Met à jour l'aéroport d'arrivée
                    vol.setMembresEquipage(volDetails.getMembresEquipage()); // Met à jour les membres d'équipage
                    return volRepository.save(vol); // Enregistre les modifications
                })
                .orElseThrow(() ->
                        new RuntimeException("Vol not found with id " + id)); // Lance une exception si le vol n'est pas trouvé
    }

    // Méthode pour supprimer un vol par son ID
    public boolean deleteVol(Long id) {
        volRepository.deleteById(id);
        return false;
    }
    public Vol addVol(Vol vol) {
        return volRepository.save(vol);
    }

}
