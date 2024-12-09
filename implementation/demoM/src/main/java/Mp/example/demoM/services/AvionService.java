package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Avion;
import Mp.example.demoM.repositories.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AvionService {
    @Autowired
    // Injection automatique de l'instance de AvionRepository
    private AvionRepository avionRepository;

    // Méthode pour récupérer tous les avions
    public List<Avion> getAllAvions() {
        // Utilise la méthode findAll() du repository pour obtenir tous les enregistrements
        return avionRepository.findAll();
    }

    // Méthode pour récupérer un avion spécifique par son ID
    public Optional<Avion> getAvionById(Long id) {
        // Utilise la méthode findById() pour obtenir un avion par son identifiant
        return avionRepository.findById(id);
    }

    // Méthode pour sauvegarder un nouvel avion dans la base de données
    public Avion saveAvion(Avion avion) {
        // Utilise la méthode save() du repository pour persister l'entité
        return avionRepository.save(avion);
    }

    // Méthode pour mettre à jour un avion existant
    public Avion updateAvion(Long id, Avion avionDetails) {
        // Recherche l'avion par ID
        return avionRepository.findById(id)
                .map(avion -> {
                    // Si l'avion existe, met à jour ses propriétés avec les nouvelles valeurs
                    avion.setTypeAvion(avionDetails.getTypeAvion()); // Mise à jour du type
                    avion.setCapacite(avionDetails.getCapacite()); // Mise à jour dela capacité
                    avion.setAnneeFab(avionDetails.getAnneeFab()); // Mise à jour de l'année de fabrication
                    avion.setModel(avionDetails.getModel()); // Mise à jour du modèle
                    avion.setAeroports(avionDetails.getAeroports()); // Mise à jour de la liste des aéroports
                    return avionRepository.save(avion); // Sauvegarde des modifications
                })
                .orElseThrow(() ->
                        // Lance une exception si l'avion avec cet ID n'existe pas
                        new RuntimeException("Avion not found with id " + id));
    }

    // Méthode pour supprimer un avion par son ID
    public void deleteAvion(Long id) {
        // Utilise la méthode deleteById() du repository pour supprimer l'entité
        avionRepository.deleteById(id);
}

}
