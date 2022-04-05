package com.mycompany.nauczyciel;

import com.mycompany.przedmiot.Przedmiot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nauczyciel")
public class Nauczyciel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "nauczyciel")
    private Set<Przedmiot> przedmioty=new HashSet<>();

    @Column(length = 45,nullable = false)
    private String imie;

    @Column(length = 45,nullable = false)
    private String nazwisko;

    @Column(length = 45,nullable = false)
    private String tytul;

    @Column(length = 45,nullable = false)
    private String email;

    @Column(length = 15,nullable = false)
    private String nr_tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }
}
