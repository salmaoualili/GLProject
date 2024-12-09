package Mp.example.demoM.services;

import Mp.example.demoM.Entities.MembreEquipage;
import Mp.example.demoM.repositories.MembreEquRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MembreEquipageService {
    @Autowired
    private MembreEquRepository membreEquipageRepository;

    // Récupérer tous les membres d'équipage
    public List<MembreEquipage> getAllMembresEquipage() {
        return membreEquipageRepository.findAll();
    }

    // Récupérer un membre d'équipage par ID
    public Optional<MembreEquipage> getMembreEquipageById(Long id) {
        return membreEquipageRepository.findById(id);
    }

    // Ajouter un nouveau membre d'équipage
    public MembreEquipage saveMembreEquipage(MembreEquipage membreEquipage) {
        return membreEquipageRepository.save(membreEquipage);
    }

    // Mettre à jour un membre d'équipage existant
    public MembreEquipage updateMembreEquipage(Long id, MembreEquipage membreDetails) {
        return membreEquipageRepository.findById(id)
                .map(membre -> {
                    membre.setNomComplet(membreDetails.getNomComplet());
                    membre.setFonction(membreDetails.getFonction());
                    membre.setNumLicence(membreDetails.getNumLicence());
                    membre.setNationalite(membreDetails.getNationalite());
                    membre.setOption(membreDetails.getOption());
                    return membreEquipageRepository.save(membre);
                })
                .orElseThrow(() -> new RuntimeException("Membre d'équipage non trouvé avec l'id " + id));
    }

    // Supprimer un membre d'équipage par ID
    public void deleteMembreEquipage(Long id) {
        membreEquipageRepository.deleteById(id);
    }

    // Récupérer le nom complet d'un membre d'équipage par ID
    public Optional<String> getNomComplet(Long id) {
        return membreEquipageRepository.findById(id)
                .map(MembreEquipage::getNomComplet);
    }

    // Modifier le nom complet d'un membre d'équipage
    public void setNomComplet(Long id, String nouveauNom) {
        membreEquipageRepository.findById(id)
                .ifPresent(membre -> {
                    membre.setNomComplet(nouveauNom);
                    membreEquipageRepository.save(membre);
                });
    }

    // Récupérer la fonction d'un membre d'équipage
    public Optional<String> getFonction(Long id) {
        return membreEquipageRepository.findById(id)
                .map(MembreEquipage::getFonction);
    }

    // Modifier la fonction d'un membre d'équipage
    public void setFonction(Long id, String nouvelleFonction) {
        membreEquipageRepository.findById(id)
                .ifPresent(membre -> {
                    membre.setFonction(nouvelleFonction);
                    membreEquipageRepository.save(membre);
                });
    }

    // Récupérer le numéro de licence d'un membre d'équipage
    public Optional<String> getNumLicence(Long id) {
        return membreEquipageRepository.findById(id)
                .map(MembreEquipage::getNumLicence);
    }

    // Modifier le numéro de licence d'un membre d'équipage
    public void setNumLicence(Long id, String nouveauNumLicence) {
        membreEquipageRepository.findById(id)
                .ifPresent(membre -> {
                    membre.setNumLicence(nouveauNumLicence);
                    membreEquipageRepository.save(membre);
                });
    }

    // Récupérer la nationalité d'un membre d'équipage
    public Optional<String> getNationalite(Long id) {
        return membreEquipageRepository.findById(id)
                .map(MembreEquipage::getNationalite);
    }

    // Modifier la nationalité d'un membre d'équipage
    public void setNationalite(Long id, String nouvelleNationalite) {
        membreEquipageRepository.findById(id)
                .ifPresent(membre -> {
                    membre.setNationalite(nouvelleNationalite);
                    membreEquipageRepository.save(membre);
                });
    }

    // Récupérer l'option d'un membre d'équipage
    public Optional<String> getOption(Long id) {
        return membreEquipageRepository.findById(id)
                .map(MembreEquipage::getOption);
    }

    // Modifier l'option d'un membre d'équipage
    public void setOption(Long id, String nouvelleOption) {
        membreEquipageRepository.findById(id)
                .ifPresent(membre -> {
                    membre.setOption(nouvelleOption);
                    membreEquipageRepository.save(membre);
                });
    }

    public MembreEquipage createMembreEquipage(MembreEquipage membreEquipage) {
        return membreEquipageRepository.save(membreEquipage);
    }

}
