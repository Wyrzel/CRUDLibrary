package com.wyrzel.biblioteka.controller;


import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.model.Rent;
import com.wyrzel.biblioteka.service.Book.BookServiceImpl;
import com.wyrzel.biblioteka.service.Rent.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private RentServiceImpl rentService;


    @RequestMapping(value = "/allBooks")
    public ModelAndView allBooks(ModelAndView modelAndView) {
        List<Book> books = bookService.getAllBooks();

        modelAndView.addObject("listBooks", books);
        modelAndView.setViewName("allBooks");

        return modelAndView;
    }


    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public ModelAndView newBook() {
        return new ModelAndView("addBook", "command", new Book());

    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public ModelAndView updateBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        return new ModelAndView("editBook", "command", book);

    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        book.setAddingDate(LocalDate.now());

        bookService.addBook(book);

        return new ModelAndView("redirect:/allBooks");
    }

    @RequestMapping(value = {"/editBook/save"}, method = RequestMethod.PUT)
    public ModelAndView saveeditedBook(@ModelAttribute Book book) {
        book.setAddingDate(LocalDate.now());
        bookService.updateBook(book.getId(), book);
        return new ModelAndView("redirect:/allBooks");
    }


    @GetMapping(value = "/deleteBook/{id}")
    public ModelAndView deleteBook(@PathVariable long id) {

        bookService.deleteBook(id);
        return new ModelAndView("redirect:/allBooks");
    }

    @GetMapping(value = "/book/{id}")
    public ModelAndView detailBook(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBook(id);
        modelAndView.addObject("book", book);

        System.out.println(book.getBookHistory().isEmpty());

        List<Rent> bookHistory=rentService.findRentsByBook(book);
        modelAndView.addObject("bookHistory", bookHistory);
        modelAndView.setViewName("bookDetails");
        return modelAndView;

    }

}
