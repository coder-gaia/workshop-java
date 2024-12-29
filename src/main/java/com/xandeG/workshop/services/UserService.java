package com.xandeG.workshop.services;

import com.xandeG.workshop.DTO.UserDTO;
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
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User with id: " + id + " wasn't found."));
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

}
