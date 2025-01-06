package com.xandeG.workshop.resource;

import com.xandeG.workshop.domain.Post;
import com.xandeG.workshop.resource.utils.URL;
import com.xandeG.workshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String txt) throws UnsupportedEncodingException {
        txt = URL.decodeParam(txt);
        List<Post> list = postService.findByTitle(txt);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String txt,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) throws UnsupportedEncodingException {

        txt = URL.decodeParam(txt);
        Date dateMin = URL.dateConverter(minDate, new Date(0L));
        Date dateMax = URL.dateConverter(maxDate, new Date());
        List<Post> list = postService.fullSearch(txt, dateMin, dateMax);
        return ResponseEntity.ok().body(list);
    }

}
