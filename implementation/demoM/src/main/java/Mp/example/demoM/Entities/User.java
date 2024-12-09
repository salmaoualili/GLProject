package Mp.example.demoM.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String NomComplet;

    @OneToMany
    @JoinColumn(name = "user_id") 
    private List<Reservation> reservations;

    public User(Long id, String password, String email, String nomComplet) {
        this.id = id;
        this.password = password;
        this.email = email;
        NomComplet = nomComplet;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomComplet(String nomComplet) {
        NomComplet = nomComplet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", NomComplet='" + NomComplet + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(NomComplet, user.NomComplet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, NomComplet);
    }
    public Object getnomComplet() {
        return null;
    }

    public Object getemail() {
        return null;
    }

    public void setemail(Object getemail) {
    }

    public Object getpassword() {
        return null;
    }

    public void setpassword(Object getpassword) {
    }

    public Object getNomComplet() {
        return null;
    }

    public void setNomComplet(Object nomComplet) {
    }

    public Object getEmail() {
        return null;
    }

    public static void setnomComplet(Object nomComplet) {
    }
}
