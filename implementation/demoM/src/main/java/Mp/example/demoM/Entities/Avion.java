package Mp.example.demoM.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avion;
    
    @Column(nullable = false)
    private String typeAvion;

    @Column(nullable = false)
    private int capacite;

    @Column(nullable = false)
    private String anneeFab;

    @Column(nullable = false)
    private String model;

    @ManyToMany
    @JoinTable(
            name = "avion_aeroport", // Nom de la table intermédiaire
            joinColumns = @JoinColumn(name = "avion_id"), // Colonne pour l'avion
            inverseJoinColumns = @JoinColumn(name = "aeroport_id") // Colonne pour l'aéroport
    )
    private List<Aeroport> aeroports;
    
    public Avion() {
    }

    public Avion(Long id_avion, String typeAvion, int capacite, String anneeFab, String model) {
        this.id_avion = id_avion;
        this.typeAvion = typeAvion;
        this.capacite = capacite;
        this.anneeFab = anneeFab;
        this.model = model;
    }
    @Override
    public String toString() {
        return "Avion{" +
                "id_avion=" + id_avion +
                ", typeAvion='" + typeAvion + '\'' +
                ", capacite=" + capacite +
                ", anneeFab='" + anneeFab + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return id_avion.equals(avion.id_avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_avion);
    }


}
