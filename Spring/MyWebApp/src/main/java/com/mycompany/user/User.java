package com.mycompany.user;

import com.mycompany.kierunek.Kierunek;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "kierunek_id", referencedColumnName = "id")
    private Kierunek kierunek;

    @Column(nullable = false,unique = true,length = 45)
    private String email;

    @Column(length = 45,nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45,nullable = false, name = "last_name")
    private String lastName;

    private boolean stypendium;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public boolean isStypendium() {
        return stypendium;
    }

    public void setStypendium(boolean stypendium) {
        this.stypendium = stypendium;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }
}
