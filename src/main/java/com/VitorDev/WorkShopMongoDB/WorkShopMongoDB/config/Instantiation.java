package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.config;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.UserRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    UserRepository ur;


    @Override
    public void run(String... args) throws Exception {

        ur.deleteAll();

        User maria = new User("Maria brown","maria@gmail.com");
        User alex = new User("Alex Green","Alex@gmail.com");
        User bob = new User("Bob Grey","bob@gmail.com");

        ur.saveAll(Arrays.asList(maria,alex,bob));
    }
}
