package com.biblioteca.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Long count() {
        return this.bookRepository.count();
    }

    @Override
    public List<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        Book existingBook = this.bookRepository.findById(book.getIdBook()).orElse(null);
        if(existingBook != null){
            existingBook.setName(book.getName());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setEditorial(book.getEditorial());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setImagePath(book.getImagePath());
            existingBook.setLentTo(book.getLentTo());
            return this.bookRepository.save(existingBook);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if(this.bookRepository.existsById(id))
            this.bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Book> findByLentTo(String lentTo) {
        return this.bookRepository.findByLentTo(lentTo);
    }
}
