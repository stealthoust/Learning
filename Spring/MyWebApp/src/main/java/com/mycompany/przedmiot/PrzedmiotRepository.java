package com.mycompany.przedmiot;

import com.mycompany.user.User;
import org.springframework.data.repository.CrudRepository;

public interface PrzedmiotRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
