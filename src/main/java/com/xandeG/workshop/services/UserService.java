package com.xandeG.workshop.services;

import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
