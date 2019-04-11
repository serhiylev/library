package com.softserve.dao;

import com.softserve.entity.Author;

import java.util.List;

public interface AuthorDao {
    void createAuthor(Author author);

    List<Author> retrieveAllAuthors();

    Author retrieveAuthor(int id);

    void updateAuthor(Author author);

    void deleteAuthor(Author author);
}
