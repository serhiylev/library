package com.softserve.controllers;

import com.softserve.entity.Book;
import java.util.List;

public interface BookService {
    void createBook(Book book);

    List<Book> retrieveAllBooks();

    Book retrieveBook(Integer id);

    void updateBook(Book book);

    void deleteBook(Book book);
}
