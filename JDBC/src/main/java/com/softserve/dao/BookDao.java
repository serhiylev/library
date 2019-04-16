package com.softserve.dao;



import com.softserve.entity.Book;

import java.util.List;

public interface BookDao {
    void createBook(Book book);

    List<Book> retrieveAllBooks();

    Book retrieveBook(int id);

    void updateBook(Book book);

    void deleteBook(Book book);
}
