package Mp.example.demoM.Entities;

import jakarta.persistence.*;
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paiement;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    
    public Paiement() {
    }
    public Paiement(Long id_paiement, Reservation reservation) {
        this.id_paiement = id_paiement;
        this.reservation = reservation;
    }
}
