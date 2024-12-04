package Mp.example.demoM.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MembreEquipage extends Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_membre_equipage;

    @Column(nullable = false)
    private String nomComplet;

    @Column(nullable = false)
    private String fonction;

    @Column(nullable = false)
    private String numLicence;

    @Column(nullable = false)
    private String nationalite;

    @Column(nullable = true)
    private String option;

    @ManyToMany(mappedBy = "membresEquipage")
    private List<Vol> vols;
    
     public MembreEquipage() {
    }

    public MembreEquipage(Long id_membre_equipage, String nomComplet, String fonction, String numLicence, String nationalite, String option) {
        this.id_membre_equipage = id_membre_equipage;
        this.nomComplet = nomComplet;
        this.fonction = fonction;
        this.numLicence = numLicence;
        this.nationalite = nationalite;
        this.option = option;
    }
    @Override
    public String toString() {
        return "MembreEquipage{" +
                "id_membre_equipage=" + id_membre_equipage +
                ", nomComplet='" + nomComplet + '\'' +
                ", fonction='" + fonction + '\'' +
                ", numLicence='" + numLicence + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembreEquipage that = (MembreEquipage) o;
        return id_membre_equipage.equals(that.id_membre_equipage);
    }

    @Override
    public int hashCode() {
        return id_membre_equipage.hashCode();
    }

    public void setAdmin(Admin admin) {
    }
}
