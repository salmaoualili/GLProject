package Mp.example.demoM.services;

import Mp.example.demoM.Entities.User;
import Mp.example.demoM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Récupérer un utilisateur par ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Enregistrer un nouvel utilisateur
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Mettre à jour un utilisateur existant
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setnomComplet(userDetails.getNomComplet());
                    user.setemail(userDetails.getemail());
                    user.setpassword(userDetails.getpassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Supprimer un utilisateur par ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    // Récupérer un utilisateur par nom complet
    public Optional<User> getUserByNomComplet(String nomComplet) {
        return userRepository.findByNomComplet(nomComplet);
    }

    // Vérifier si un utilisateur existe par ID
    public Boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    // Vérifier si un utilisateur existe par nom complet
    public Boolean existsByNomComplet(String nomComplet) {
        return userRepository.existsByNomComplet(nomComplet);
    }
}
