package Mp.example.demoM.Entities;

import jakarta.persistence.*;
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

    public long getId_passager() {
        return id_passager;
    }

    public void setId_passager(long id_passager) {
        this.id_passager = id_passager;
    }

    public String getNumPasseport() {
        return numPasseport;
    }

    public void setNumPasseport(String numPasseport) {
        this.numPasseport = numPasseport;
    }

    public String getNumCarteIdentite() {
        return numCarteIdentite;
    }

    public void setNumCarteIdentite(String numCarteIdentite) {
        this.numCarteIdentite = numCarteIdentite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
