package Mp.example.demoM.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vol;
    private String numVol;
    private String volIATA;
    private String dateVol;

    @ManyToOne
    @JoinColumn(name = "aeroport_depart_id")
    private Aeroport aeroportDepart;

    @ManyToOne
    @JoinColumn(name = "aeroport_arrive_id")
    private Aeroport aeroportArrive;

    @OneToMany(mappedBy = "vol")
    private List<Reservation> reservations;

    @ManyToMany
    private List<MembreEquipage> membresEquipage;

    @Override
    public String toString() {
        return "Vol{" +
                "id_vol=" + id_vol +
                ", numVol='" + numVol + '\'' +
                ", volIATA='" + volIATA + '\'' +
                ", dateVol='" + dateVol + '\'' +
                ", aeroportDepart=" + aeroportDepart +
                ", aeroportArrive=" + aeroportArrive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vol vol = (Vol) o;
        return id_vol.equals(vol.id_vol);
    }

    @Override
    public int hashCode() {
        return id_vol.hashCode();
    }

   
}
