package com.xandeG.workshop.DTO;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    private String comment;
    private Date date;

    private AuthorDTO authorDTO;

    public CommentDTO(){}

    public CommentDTO(String comment, Date date, AuthorDTO authorDTO) {
        this.comment = comment;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
