
package com.wyrzel.biblioteka.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rent_id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Rent(LocalDate rentDate, LocalDate returnDate, Book book, User user) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.book = book;
        this.user = user;
    }

    public Long getRent_id() {
        return rent_id;
    }

    public void setRent_id(Long rent_id) {
        this.rent_id = rent_id;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
