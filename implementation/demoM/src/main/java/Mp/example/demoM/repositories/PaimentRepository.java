package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaimentRepository extends JpaRepository<Paiement,Long> {

    Paiement findByReservation_Id(Long reservationId);

    boolean existsByReservation_Id(Long reservationId);
}
