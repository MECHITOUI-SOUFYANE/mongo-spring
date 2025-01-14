package com.mongo.services.api;

import com.mongo.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getUsersByFirstName(String firstName);
    User getUserByEmail(String email);
}
