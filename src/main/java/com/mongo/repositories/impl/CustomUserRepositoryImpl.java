package com.mongo.repositories.impl;

import com.mongo.entities.User;
import com.mongo.repositories.api.CustomUserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final MongoTemplate mongoTemplate;

    public CustomUserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<User> findAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void updateUser(String fisrtName, String email) {
        Query queryFirstName = new Query(Criteria.where("firstName").is(fisrtName));
        Update update = new Update();
        update.set("email",email);
        UpdateResult updateResult = mongoTemplate.updateFirst(queryFirstName, update, User.class);
        if(updateResult.getModifiedCount() == 0)
            System.out.println("No documents updated");
        else
            System.out.println(updateResult.getModifiedCount() + " document(s) updated..");
    }
}
