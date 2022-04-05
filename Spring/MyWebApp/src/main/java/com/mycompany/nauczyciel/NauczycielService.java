package com.mycompany.nauczyciel;

import com.mycompany.user.User;
import com.mycompany.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NauczycielService {
    @Autowired
    private NauczycielRepository repo;

    public List<Nauczyciel> listaNauczycieli() {
        return (List<Nauczyciel>) repo.findAll();
    }

    public void save (Nauczyciel nauczyciel) {
        repo.save(nauczyciel);
    }
    public Nauczyciel get(Integer id) throws NauczycielNotFoundException {
        Optional<Nauczyciel> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new NauczycielNotFoundException("Nie znaleziono nauczyciela o ID: " + id);
    }

    public void delete(Integer id) throws NauczycielNotFoundException {
        Long count=repo.countById(id);
        if(count==null || count==0){
            throw new NauczycielNotFoundException("Nie znaleziono nauczyciela o ID: " + id);
        }
        repo.deleteById(id);
    }
}
