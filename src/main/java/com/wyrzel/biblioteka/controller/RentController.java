package com.wyrzel.biblioteka.controller;

import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.service.Book.BookServiceImpl;
import com.wyrzel.biblioteka.service.Rent.RentServiceImpl;
import com.wyrzel.biblioteka.service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import java.time.LocalDate;

@Controller
public class RentController {


    @Autowired
    public BookServiceImpl bookService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public RentServiceImpl rentService;


    @RequestMapping(value = "/book/rent/{id}", method = RequestMethod.GET)
    public ModelAndView RentBook(Principal principal, @PathVariable Long id) {
        Book book = bookService.getBook(id);
      //  if (book.getStatus() == Book.Status.AVALIBLE) {
            User user = userService.findByEmail(principal.getName());
            book.setStatus(Book.Status.LOANED);
            LocalDate rentDate = LocalDate.now();
            LocalDate returnDate = rentDate.plusMonths(1);
            Rent rent = new Rent(rentDate, returnDate, book, user);
            rentService.saveRent(rent);

            return new ModelAndView("redirect:/profile");
      //  } else
    }
}
