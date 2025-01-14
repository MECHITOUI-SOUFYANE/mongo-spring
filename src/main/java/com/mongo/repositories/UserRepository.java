package com.mongo.repositories;

import com.mongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User , String> {

    @Query(value = "{email: '?0'}" , fields = "{ firstName: 1 ,lastName: 1,email: 1}")
    Optional<User> findUserByEmail(String email);

    @Query(value = "{firstName: '?0'}" , fields = "{ firstName: 1 ,lastName: 1,email: 1}")
    List<User> findUserByFirstName(String firstName);

}
