package com.wyrzel.biblioteka.service.Rent;

import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;

import java.util.List;

public interface RentService {

    List<Rent> findRentsByUser(User user);

    void saveRent(Rent rent);

    void deleteRent(Long id);

    List<Rent> getAllRents();

    Rent findRent(Long id);

    List<Rent> findRentsByBook(Book book);
}
