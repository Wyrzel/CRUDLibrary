
package com.wyrzel.biblioteka.restController;

import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.service.Book.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRestController {

    @Autowired
    private BookServiceImpl bookService;




    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> findAllBooks() {
        return bookService.getAllBooks();
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }


}

