package com.xandeG.workshop.config;

import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User jake = new User(null, "Jake Green", "jake@gmail.com");
        User monica = new User(null, "Monica Suarez", "mon@gmail.com");
        User cecile = new User(null, "Cecile Johnson", "cecl@gmail.com");

        userRepository.saveAll(Arrays.asList(jake, monica, cecile));
    }
}
