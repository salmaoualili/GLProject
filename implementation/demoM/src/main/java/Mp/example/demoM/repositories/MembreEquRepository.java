package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.MembreEquipage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MembreEquRepository extends JpaRepository<MembreEquipage, Long> {

    List<MembreEquipage> findByFonction(String fonction);

    List<MembreEquipage> findByNationalite(String nationalite);

    List<MembreEquipage> findByNomComplet(String nomComplet);

    boolean existsByNumLicence(String numLicence);
}
