package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByid(String id);
    boolean existsByid(String id);
    Optional<User> findByNomComplet(String NomComplet);
    boolean existsByNomComplet(String NomComplet);

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
