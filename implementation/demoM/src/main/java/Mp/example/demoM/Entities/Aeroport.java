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


}
