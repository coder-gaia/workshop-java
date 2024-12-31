package com.xandeG.workshop.DTO;


import com.xandeG.workshop.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    @Id
    private String id;
    private String name;

    public AuthorDTO(){}

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
