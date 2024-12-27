package com.xandeG.workshop.resource;

import com.xandeG.workshop.DTO.UserDTO;
import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.UserRepository;
import com.xandeG.workshop.services.UserService;
import com.xandeG.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userService.findById(id).orElseThrow();
        return ResponseEntity.ok().body(new UserDTO(obj));
    }


    @PostMapping("/new")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatusCode.valueOf(201));
    }
}
