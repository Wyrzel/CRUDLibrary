package com.wyrzel.biblioteka.repository;


import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {


    @Query("SELECT r FROM Rent r " +
            "LEFT JOIN FETCH r.user " +
            "LEFT JOIN FETCH r.book " +
            "WHERE r.user = :user")
    List<Rent> findByUser (@Param("user") User user);

    @Query("SELECT r FROM Rent r " +
            "LEFT JOIN FETCH r.book " +
            "LEFT JOIN FETCH r.user " +
            "WHERE r.book = :book")
    List<Rent> findByBook (@Param("book") Book book);



}

