package com.xandeG.workshop.resource;

import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> indAll(){
        User john = new User("1", "John", "john@hotmail.com");
        User marie = new User("2", "Marie", "marie@hotmail.com");

        List<User> list = new ArrayList<>();

        list.add(john);
        list.add(marie);

        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }
}
