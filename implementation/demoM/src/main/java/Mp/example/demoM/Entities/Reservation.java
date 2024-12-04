package Mp.example.demoM.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reservation;

    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol volReserve;

    @ManyToOne
    @JoinColumn(name = "passager_id")
    private Passager passagerReservant;

    private String dateReservation;
    private String status;
    private double prixTotal;

    @OneToOne(mappedBy = "reservation")
    private Paiement paiement;

    public Reservation() {
    }

    public Reservation(Long id_reservation, Vol volReserve, Passager passagerReservant, String dateReservation, String status, double prixTotal, Paiement paiement) {
        this.id_reservation = id_reservation;
        this.volReserve = volReserve;
        this.passagerReservant = passagerReservant;
        this.dateReservation = dateReservation;
        this.status = status;
        this.prixTotal = prixTotal;
        this.paiement = paiement;
    }
    public String toString() {
        return "Reservation{" +
                "id_reservation=" + id_reservation +
                ", volReserve=" + volReserve +
                ", passagerReservant=" + passagerReservant +
                ", dateReservation='" + dateReservation + '\'' +
                ", status='" + status + '\'' +
                ", prixTotal=" + prixTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id_reservation.equals(that.id_reservation);
    }

    @Override
    public int hashCode() {
        return id_reservation.hashCode();
    }

}
