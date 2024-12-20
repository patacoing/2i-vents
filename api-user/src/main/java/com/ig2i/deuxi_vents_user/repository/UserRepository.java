package com.ig2i.deuxi_vents_user.repository;

import com.ig2i.deuxi_vents_user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
   
    @Query("{}")
    List<User> findAll();

    User findUserById(String id);

    User findUserByFirstNameAndLastName(String firstName, String lastName);
}
