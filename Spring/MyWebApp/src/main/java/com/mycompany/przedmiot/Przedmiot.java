package com.mycompany.przedmiot;

import com.mycompany.kierunek.Kierunek;
import com.mycompany.nauczyciel.Nauczyciel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "przedmiot")
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nauczyciel_id", referencedColumnName = "id")
    private Nauczyciel nauczyciel;

    @Column(length = 45,nullable = false)
    private String nazwa;

    @Column(length = 45,nullable = false)
    private String typ; //wykład, zajecia praktyczne, laboratorium

    @Column(length = 45,nullable = true)
    private String opis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Nauczyciel getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(Nauczyciel nauczyciel) {
        this.nauczyciel = nauczyciel;
    }




/*    @ManyToMany
    @JoinTable(
            name = "przedmioty_kierunek",
            joinColumns = @JoinColumn(name = "przedmiot_id"),
            inverseJoinColumns = @JoinColumn(name = "kierunek_id")
    )
    private Set<Kierunek> kierunki=new HashSet<>();

    public Set<Kierunek> getKierunki() {
        return kierunki;
    }

    public void setKierunki(Set<Kierunek> kierunki) {
        this.kierunki = kierunki;
    }*/

}
