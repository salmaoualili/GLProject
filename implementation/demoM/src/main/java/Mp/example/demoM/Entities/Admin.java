package Mp.example.demoM.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Getter
@Setter
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;

    @OneToMany
    @JoinColumn(name = "admin_id")
    private List<MembreEquipage> membres = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "admin_id")
    private List<Avion> avions = new ArrayList<>();;

    @OneToMany
    @JoinColumn(name = "admin_id")
    private List<Vol> vols = new ArrayList<>();;

    @OneToMany
    @JoinColumn(name = "admin_id")
    private List<Aeroport> aeroports = new ArrayList<>();;

    public Admin(Long id_admin, String password, String email, String nomComplet) {
        super(id_admin, password, email, nomComplet);
    }

    public Admin() {

    }

    public static void getnomComplet(Object getnomComplet) {
    }



    public void ajouterMembre(MembreEquipage membre) {

        membres.add(membre);
        membre.setAdmin(this);
    }

    public void supprimerMembre(MembreEquipage membre) {

        membres.remove(membre);
        membre.setAdmin(null);
    }

    public List<MembreEquipage> recupererMembres() {
        return this.membres;
    }

    public void mettreAJourMembre(MembreEquipage membre) {
       
    }


    public void ajouterAvion(Avion avion) {
        this.avions.add(avion);
    }

    public void supprimerAvion(Avion avion) {
        this.avions.remove(avion);
    }

    public List<Avion> recupererAvions() {
        return this.avions;
    }

    public void mettreAJourAvion(Avion avion) {
     
    }

    
    public void ajouterVol(Vol vol) {
        this.vols.add(vol);
    }

    public void supprimerVol(Vol vol) {
        this.vols.remove(vol);
    }

    public List<Vol> recupererVols() {
        return this.vols;
    }

    public void mettreAJourVol(Vol vol) {
        
    }

    public void ajouterAeroport(Aeroport aeroport) {
        this.aeroports.add(aeroport);
    }

    public void supprimerAeroport(Aeroport aeroport) {
        this.aeroports.remove(aeroport);
    }

    public List<Aeroport> recupererAeroports() {
        return this.aeroports;
    }

    public void mettreAJourAeroport(Aeroport aeroport) {
     
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id_admin.equals(admin.id_admin);
    }

    @Override
    public int hashCode() {
        return id_admin.hashCode();
    }







}
