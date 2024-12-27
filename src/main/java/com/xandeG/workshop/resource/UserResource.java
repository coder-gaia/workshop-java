package com.xandeG.workshop.resource;

import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.UserRepository;
import com.xandeG.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> indAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatusCode.valueOf(201));
    }
}
