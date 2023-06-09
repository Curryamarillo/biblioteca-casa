package com.biblioteca.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String nombre);

    List<Book> findByLentTo(String lentTo);
}
