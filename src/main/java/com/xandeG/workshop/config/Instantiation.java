package com.xandeG.workshop.config;

import com.xandeG.workshop.DTO.AuthorDTO;
import com.xandeG.workshop.DTO.CommentDTO;
import com.xandeG.workshop.domain.Post;
import com.xandeG.workshop.domain.User;
import com.xandeG.workshop.repositories.PostRepository;
import com.xandeG.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User jake = new User(null, "Jake Green", "jake@gmail.com");
        User monica = new User(null, "Monica Suarez", "mon@gmail.com");
        User cecile = new User(null, "Cecile Johnson", "cecl@gmail.com");

        userRepository.saveAll(Arrays.asList(jake, monica, cecile));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Road trip!!", "I am off to London with some friends!", new AuthorDTO(jake));
        Post post2 = new Post(null, sdf.parse("10/12/2024"), "Achievements!", "Today marks 1 year clean!", new AuthorDTO(cecile));

        CommentDTO comment_1 = new CommentDTO("Safe travel, buddie!", sdf.parse("21/03/2018"), new AuthorDTO(monica));
        CommentDTO comment_2 = new CommentDTO("Sounds awesome, enjoy.", sdf.parse("22/03/2018"), new AuthorDTO(cecile));
        CommentDTO comment_3 = new CommentDTO("You're tough, man, I keep tellin u that!!.", sdf.parse("22/03/2018"), new AuthorDTO(jake));

        post1.getComments().addAll(Arrays.asList(comment_1, comment_2));
        post2.getComments().add(comment_3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        jake.getPosts().add(post1);
        cecile.getPosts().add(post2);

        userRepository.saveAll(Arrays.asList(jake, cecile));
    }
}
