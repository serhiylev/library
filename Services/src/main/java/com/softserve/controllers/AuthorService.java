package com.softserve.controllers;


import com.softserve.entity.Author;

import java.util.List;

public interface AuthorService {
    void createAuthor(Author author);

    List<Author> retrieveAllAuthors();

    Author retrieveAuthor(Integer id);

    void updateAuthor(Author author);

    void deleteAuthorById(int id);
}
