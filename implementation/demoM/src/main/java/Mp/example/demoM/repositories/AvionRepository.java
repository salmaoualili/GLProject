package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

    boolean existsByTypeAvion(String typeAvion);

    boolean existsByModel(String model);

    List<Avion> findByTypeAvion(String typeAvion);

    List<Avion> findByCapacite(int capacite);

    List<Avion> findByAnneeFab(String anneeFab);
}
