package com.softserve.controllers.impl;

import com.softserve.controllers.AuthorController;
import com.softserve.dao.impl.AuthorDaoImpl;
import com.softserve.entity.Author;

import java.util.List;

public class AuthorControllerImpl implements AuthorController {
    @Override
    public void createAuthor(Author author) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.createAuthor(author);
    }

    @Override
    public List<Author> retrieveAllBooks() {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        return authorDao.retrieveAllAuthors();
    }

    @Override
    public Author retrieveBook(Integer id) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        return authorDao.retrieveAuthor(id);
    }

    @Override
    public void updateBook(Author author) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteBook(Author author) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.deleteAuthor(author);
    }
}
