package com.mycompany.kierunek;

import com.mycompany.user.User;
import org.springframework.data.repository.CrudRepository;

public interface KierunekRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
