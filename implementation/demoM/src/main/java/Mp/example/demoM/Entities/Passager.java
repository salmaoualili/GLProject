package Mp.example.demoM.Entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passager extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_passager;

    @Column(nullable = false)
    private String numPasseport;

    @Column(nullable = false)
    private String numCarteIdentite;

    @Column(nullable = false)
    private String nationalite;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String telephone;

    public Passager() {
    }

    public Passager(Long id_passager, String numPasseport, String numCarteIdentite, String nationalite, String adresse, String telephone) {
        this.id_passager = id_passager;
        this.numPasseport = numPasseport;
        this.numCarteIdentite = numCarteIdentite;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.telephone = telephone;
    }


    public void ajouterReservation() {

    }
    public void supprimerReservation() {

    }
    public void recupererReservation() {

    }
    public void mettreAJourReservation() {

    }
}
