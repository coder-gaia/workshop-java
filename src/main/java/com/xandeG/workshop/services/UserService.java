package com.xandeG.workshop.services;

import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.UserRepository;
import com.xandeG.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user == null){
            throw new ObjectNotFoundException("There is no user with id: " + id + ".");
        }
        return user;
    }
}
