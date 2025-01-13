package com.mongo.repositories.api;

import com.mongo.entities.User;

import java.util.List;

public interface CustomUserRepository {
    List<User> findAllUsers();
    void updateUser(String fisrtName , String email);
}
