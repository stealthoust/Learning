package com.mycompany.kierunek;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.przedmiot.Przedmiot;
import com.mycompany.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "kierunek")
public class Kierunek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToMany (mappedBy = "kierunek")
    private Set<User> users =new HashSet<>();

    @ManyToMany(mappedBy = "kierunki")
    private Set<Przedmiot> przedmioty=new HashSet<>();

    @Column(length = 45,nullable = false)
    private String nazwa;

    @Column(length = 45,nullable = false)
    private String typ; //licencjat, inzynierskie, magisterskie


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public String getPrzedmiotyString()
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(Przedmiot przedmiot:przedmioty)
        {
            stringBuilder.append(przedmiot.getNazwa()+"("+przedmiot.getTyp()+"), ");
        }
        return stringBuilder.toString();
    }

    public String getStudenciString()
    {
        StringBuilder stringBuilder=new StringBuilder();
        for(User student:users)
        {
            stringBuilder.append(student.getFirstName()+" "+student.getLastName()+"(s"+student.getId()+"), ");
        }
        return stringBuilder.toString();
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
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
}
