package com.estudo.spring.dtos;

import com.estudo.spring.models.Book;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String tittle;
    private String author;
    private String text;
    private Integer id_category;

    public BookDTO() {
        super();
    }

    public BookDTO(Book book) {
        super();
        this.id = book.getId();
        this.tittle = book.getTittle();
        this.author = book.getAuthor();
        this.text = book.getText();
        this.id_category = book.getCategory().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }
}
