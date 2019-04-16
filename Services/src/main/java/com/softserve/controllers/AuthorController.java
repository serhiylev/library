package com.softserve.controllers;


import com.softserve.entity.Author;

import java.util.List;

public interface AuthorController {
    void createAuthor(Author author);

    List<Author> retrieveAllBooks();

    Author retrieveBook(Integer id);

    void updateBook(Author author);

    void deleteBook(Author author);
}
