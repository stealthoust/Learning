package com.mycompany.nauczyciel;

import com.mycompany.user.User;
import org.springframework.data.repository.CrudRepository;

public interface NauczycielRepository extends CrudRepository<Nauczyciel, Integer> {
    public Long countById(Integer id);
}
