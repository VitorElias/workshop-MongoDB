package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;

import java.util.Date;

public class CommentDTO {

    private String text;

    private Date date;

    private AuthorDTO Author;

    public CommentDTO() {
    }

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        Author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return Author;
    }

    public void setAuthor(AuthorDTO author) {
        Author = author;
    }


}
