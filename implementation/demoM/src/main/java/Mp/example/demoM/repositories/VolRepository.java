package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Reservation;
import Mp.example.demoM.Entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolRepository extends JpaRepository<Vol, Long> {
    List<Reservation> findByStatus(String status);

    List<Reservation> findByDateReservation(String dateReservation);

    List<Reservation> findByPassagerReservant_Id(Long passagerId);

    List<Reservation> findByVolReserve_Id(Long volId);

    boolean existsByPassagerReservant_IdAndVolReserve_Id(Long passagerId, Long volId);

}
