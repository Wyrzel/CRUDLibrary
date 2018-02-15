package com.wyrzel.biblioteka.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "book")
public class Book {

    public enum Status {
        AVALIBLE, LOANED};


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private String publishYear;
    private String author;
    //@Temporal(TemporalType.DATE)
    //@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate addingDate;
    private Status status=Status.AVALIBLE;


    public Book(String isbn, String title, String publishYear, String author, LocalDate addingDate, Status status) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
        this.addingDate = addingDate;
        this.status = status;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(LocalDate addingDate) {
        this.addingDate = addingDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
