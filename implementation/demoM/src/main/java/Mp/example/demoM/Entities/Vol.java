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

    public Long getId_vol() {
        return id_vol;
    }

    public void setId_vol(Long id_vol) {
        this.id_vol = id_vol;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public String getVolIATA() {
        return volIATA;
    }

    public void setVolIATA(String volIATA) {
        this.volIATA = volIATA;
    }

    public String getDateVol() {
        return dateVol;
    }

    public void setDateVol(String dateVol) {
        this.dateVol = dateVol;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportArrive() {
        return aeroportArrive;
    }

    public void setAeroportArrive(Aeroport aeroportArrive) {
        this.aeroportArrive = aeroportArrive;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<MembreEquipage> getMembresEquipage() {
        return membresEquipage;
    }

    public void setMembresEquipage(List<MembreEquipage> membresEquipage) {
        this.membresEquipage = membresEquipage;
    }
}
