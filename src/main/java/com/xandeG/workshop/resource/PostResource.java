package com.xandeG.workshop.resource;

import com.xandeG.workshop.DTO.UserDTO;
import com.xandeG.workshop.domain.Post;
import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.services.PostService;
import com.xandeG.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
