package com.wyrzel.biblioteka.service.Book;




import com.wyrzel.biblioteka.model.Book;
import java.util.List;

public interface BookService {

    void addBook(Book book);

    Book getBook(Long id);

    List<Book> getAllBooks();

    void deleteBook(Long id);

    void updateBook(Long id, Book book);
}
