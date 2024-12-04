package Mp.example.demoM.repositories;

import Mp.example.demoM.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findById_admin(Admin Id_Admin);
    boolean existsById_Admin(Admin Id_Admin);

    Optional<Admin> findByName(String nomComplet);
    boolean existsByName(Admin nomComplet);

}
