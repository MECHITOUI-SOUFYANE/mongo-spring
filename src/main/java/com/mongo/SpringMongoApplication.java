package com.mongo;

import com.mongo.entities.User;
import com.mongo.repositories.api.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoApplication implements CommandLineRunner {

    @Autowired
    private CustomUserRepository customUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customUserRepository.findAllUsers().forEach(System.out::println);
        customUserRepository.updateUser("test","testcosy3@gmail.com");
        System.out.println("*********************************************************************************");
        customUserRepository.findAllUsers().forEach(System.out::println);
    }
}
