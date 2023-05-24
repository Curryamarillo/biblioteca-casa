package com.biblioteca.book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Long count();

    List<Book> findByName(String nombre);


    Book create(Book libro);


    Book update(Book libro);


    void deleteById(Long id);

    void deleteAll();

    List<Book> findByLentTo(String lentTo);



}
