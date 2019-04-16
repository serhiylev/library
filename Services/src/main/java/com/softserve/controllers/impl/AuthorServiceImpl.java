package com.softserve.controllers.impl;

import com.softserve.controllers.AuthorService;
import com.softserve.dao.impl.AuthorDaoImpl;
import com.softserve.entity.Author;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Override
    public void createAuthor(Author author) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.createAuthor(author);
    }

    @Override
    public List<Author> retrieveAllAuthors() {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        System.out.println(authorDao.retrieveAllAuthors());
        return authorDao.retrieveAllAuthors();
    }

    @Override
    public Author retrieveAuthor(Integer id) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        return authorDao.retrieveAuthor(id);
    }

    @Override
    public void updateAuthor(Author author) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteAuthorById(int id) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        authorDao.getConnection();
        authorDao.deleteAuthor(id);
    }

}
