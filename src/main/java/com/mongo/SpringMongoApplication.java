package com.mongo;

import com.mongo.entities.User;
import com.mongo.repositories.api.CustomUserRepository;
import com.mongo.services.api.UserService;
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
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("************************* MongoTemplate *******************************");
        System.out.println("----- get All users ------");
        customUserRepository.findAllUsers().forEach(System.out::println);
        System.out.println("----- update user --------");
        customUserRepository.updateUser("test","testcosy3@gmail.com");
        System.out.println("----- get All users ------");
        customUserRepository.findAllUsers().forEach(System.out::println);
        System.out.println("************************************************************************");
        System.out.println("************************* Spring Data   ********************************");
        System.out.println("----- get All users ------");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("----- get user by email ------");
        System.out.println(userService.getUserByEmail("testcosy3@gmail.com"));
        System.out.println("----- get user by first name ------");
        userService.getUsersByFirstName("soufyane").forEach(System.out::println);

    }
}
