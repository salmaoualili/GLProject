package Mp.example.demoM.services;

import Mp.example.demoM.Entities.Aeroport;
import Mp.example.demoM.repositories.AeroportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AeroportService {
        @Autowired
        private AeroportRepository aeroportRepository;

        // Récupérer tous les aéroports
        public List<Aeroport> getAllAeroports() {
            return aeroportRepository.findAll();
        }

        // Récupérer un aéroport par ID
        public Optional<Aeroport> getAeroportById(Long id) {
            return aeroportRepository.findById(id);
        }

        // Ajouter un nouvel aéroport
        public Aeroport saveAeroport(Aeroport aeroport) {
            return aeroportRepository.save(aeroport);
        }

        // Mettre à jour un aéroport existant
        public Aeroport updateAeroport(Long id, Aeroport aeroportDetails) {
            return aeroportRepository.findById(id)
                    .map(aeroport -> {
                        aeroport.setAeroportIATA(aeroportDetails.getAeroportIATA());
                        aeroport.setNomAeroport(aeroportDetails.getNomAeroport());
                        aeroport.setVille(aeroportDetails.getVille());
                        aeroport.setPays(aeroportDetails.getPays());
                        aeroport.setCapacite(aeroportDetails.getCapacite());
                        return aeroportRepository.save(aeroport);
                    })
                    .orElseThrow(() -> new RuntimeException("Aéroport non trouvé avec l'id " + id));
        }

        // Supprimer un aéroport par ID
        public void deleteAeroport(Long id) {
            aeroportRepository.deleteById(id);
        }

    public Aeroport createAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

}
