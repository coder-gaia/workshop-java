package com.xandeG.workshop.services;

import com.xandeG.workshop.DTO.UserDTO;
import com.xandeG.workshop.domain.Post;
import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.PostRepository;
import com.xandeG.workshop.repositories.UserRepository;
import com.xandeG.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post with id: " + id + " wasn't found."));
    }

}
