package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassaferRepo extends JpaRepository<Passager,Long> {

    Optional<Passager> findByNumPasseport(String numPasseport);

    Optional<Passager> findByNumCarteIdentite(String numCarteIdentite);

    boolean existsByNumPasseport(String numPasseport);

    boolean existsByNumCarteIdentite(String numCarteIdentite);
}
