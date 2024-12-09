package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, Long> {

    Optional<Aeroport> findByAeroportIATA(String aeroportIATA);

    List<Aeroport> findByVille(String ville);

    List<Aeroport> findByPays(String pays);

    boolean existsByNomAeroport(String nomAeroport);

    boolean existsByAeroportIATA(String aeroportIATA);

}
