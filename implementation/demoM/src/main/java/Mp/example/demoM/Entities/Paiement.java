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
    private double montant;
    private String datePaiement;

    public Paiement(Object o, String number, String carteBancaire, double v, String valide) {
    }
    public Paiement(Long id_paiement, Reservation reservation) {
        this.id_paiement = id_paiement;
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Long getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(Long id_paiement) {
        this.id_paiement = id_paiement;
    }

    public double getMontant() {
        return montant;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setMontant(double montant) {
        this.montant = montant; // Assurez-vous que l'attribut "montant" est défini dans la classe Paiement.
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement; // Assurez-vous que l'attribut "datePaiement" est défini dans la classe Paiement.
    }
}
