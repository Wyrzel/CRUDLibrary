package com.wyrzel.biblioteka.service.Book;



import com.wyrzel.biblioteka.model.Book;
import com.wyrzel.biblioteka.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> AllBooks = new ArrayList<Book>();
        bookRepository.findAll().forEach(AllBooks::add);
        return AllBooks;
    }


    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);

    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

    public void updateBook(Long id, Book book) {
        bookRepository.save(book);

    }
}


