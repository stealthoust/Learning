package com.mycompany.kierunek;


import com.mycompany.przedmiot.Przedmiot;
import com.mycompany.przedmiot.PrzedmiotRepository;
import com.mycompany.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KierunekService {

    @Autowired
    private KierunekRepository repo;

    public List<Kierunek> listaKierunkow() {
        return (List<Kierunek>) repo.findAll();
    }


     public void save(Kierunek kierunek) {
        repo.save(kierunek);
    }
    public Kierunek get(Integer id) throws KierunekNotFoundException {
        Optional<Kierunek> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new KierunekNotFoundException("Nie znaleziono kierunku o ID: " + id);
    }

    public void delete(Integer id) throws KierunekNotFoundException {
        Long count=repo.countById(id);
        if(count==0||count==null)
        {
            throw new KierunekNotFoundException("Nie znaleziono kierunku o ID: " + id);
        }
        repo.deleteById(id);
    }

}
