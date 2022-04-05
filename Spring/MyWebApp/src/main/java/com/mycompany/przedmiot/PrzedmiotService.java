package com.mycompany.przedmiot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrzedmiotService {
    @Autowired
    private PrzedmiotRepository repo;

    public List<Przedmiot> listaPrzedmiotow(){
        return (List<Przedmiot>) repo.findAll();
    }
    public  void save(Przedmiot przedmiot){
        repo.save(przedmiot);
    }
    public Przedmiot get(Integer id) throws PrzedmiotNotFoundException {
        Optional<Przedmiot> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new PrzedmiotNotFoundException("Przedmiot o id: " + id + " nie został znaleziony");
    }
    public void delete(Integer id) throws PrzedmiotNotFoundException {
        Long count = repo.countById(id);
        if(count==null || count==0){
            throw new PrzedmiotNotFoundException("Przedmiot o id: " + id + " nie został znaleziony");
        }
        repo.deleteById(id);
    }
}
