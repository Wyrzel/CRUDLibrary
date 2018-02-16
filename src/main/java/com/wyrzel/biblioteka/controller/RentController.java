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

import javax.transaction.Transactional;
import java.security.Principal;

import java.time.LocalDate;
import java.util.List;

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

            User user = userService.findByEmail(principal.getName());
            book.setStatus(Book.Status.LOANED);
            LocalDate rentDate = LocalDate.now();
            LocalDate returnDate = rentDate.plusMonths(1);
            Rent rent = new Rent(rentDate, returnDate, book, user);
            rentService.saveRent(rent);

            return new ModelAndView("redirect:/profile");
    }

    @RequestMapping(value = "/book/rents",method = RequestMethod.GET)
    public ModelAndView AllRents(ModelAndView modelAndView){
        List<Rent> rents = rentService.getAllRents();
        modelAndView.addObject("listRents", rents);
        modelAndView.setViewName("allRents");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteRent/{id}", method = RequestMethod.GET)
    public ModelAndView DeleteRent(@PathVariable Long id, ModelAndView modelAndView){
        Rent rent =rentService.findRent(id);
        rent.setReturnDate(LocalDate.now());
        rentService.saveRent(rent);
        Book book= rent.getBook();
        book.setStatus(Book.Status.AVALIBLE);
        bookService.updateBook(book.getId(), book);
        return new ModelAndView("redirect:/allRents");
    }

}
