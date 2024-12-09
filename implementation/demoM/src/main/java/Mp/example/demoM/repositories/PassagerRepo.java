package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassagerRepo extends JpaRepository<Passager,Long> {

    Optional<Passager> findByNumPasseport(String numPasseport);
    Optional<Passager> findByid_passager(Long id_passager);

    Optional<Passager> findByNumCarteIdentite(String numCarteIdentite);

    boolean existsByNumPasseport(String numPasseport);

    boolean existsByNumCarteIdentite(String numCarteIdentite);

    boolean existsByEmail(String email);
}
