package com.wyrzel.biblioteka.repository;


import com.wyrzel.biblioteka.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

  //  List<Book> findByAuthor(String author);


}
