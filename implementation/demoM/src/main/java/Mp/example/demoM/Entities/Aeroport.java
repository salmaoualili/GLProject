package Mp.example.demoM.Entities;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aeroport;

    @Column(nullable = false, unique = true)
    private String aeroportIATA;

    @Column(nullable = false)
    private String nomAeroport;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String pays;

    @Column(nullable = false)
    private int capacite;

    @OneToMany
    @JoinColumn(name = "aeroport_depart_id")  
    private List<Vol> volsDepart;

    @OneToMany
    @JoinColumn(name = "aeroport_arrive_id")  
    private List<Vol> volsArrive;
     public Aeroport() {
    }

    public Aeroport(Long id_aeroport, String aeroportIATA, String nomAeroport, String ville, String pays, int capacite) {
        this.id_aeroport = id_aeroport;
        this.aeroportIATA = aeroportIATA;
        this.nomAeroport = nomAeroport;
        this.ville = ville;
        this.pays = pays;
        this.capacite = capacite;
    }
    @Override
    public String toString() {
        return "Aeroport{" +
                "id_aeroport=" + id_aeroport +
                ", aeroportIATA='" + aeroportIATA + '\'' +
                ", nomAeroport='" + nomAeroport + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", capacite=" + capacite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroport aeroport = (Aeroport) o;
        return id_aeroport.equals(aeroport.id_aeroport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_aeroport);
    }

    public Long getId_aeroport() {
        return id_aeroport;
    }

    public void setId_aeroport(Long id_aeroport) {
        this.id_aeroport = id_aeroport;
    }

    public String getAeroportIATA() {
        return aeroportIATA;
    }

    public void setAeroportIATA(String aeroportIATA) {
        this.aeroportIATA = aeroportIATA;
    }

    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Vol> getVolsDepart() {
        return volsDepart;
    }

    public void setVolsDepart(List<Vol> volsDepart) {
        this.volsDepart = volsDepart;
    }

    public List<Vol> getVolsArrive() {
        return volsArrive;
    }

    public void setVolsArrive(List<Vol> volsArrive) {
        this.volsArrive = volsArrive;
    }
}
