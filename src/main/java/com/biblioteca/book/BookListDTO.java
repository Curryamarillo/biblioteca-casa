package com.biblioteca.book;

import java.util.List;

public class BookListDTO {
    private List<Book> books;
    public BookListDTO(){}
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
