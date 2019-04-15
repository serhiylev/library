package com.softserve.controllers.impl;

import com.softserve.controllers.BookController;
import com.softserve.dao.impl.BookDaoImpl;
import com.softserve.entity.Book;

import java.util.List;

public class BookControllerImpl implements BookController {
    @Override
    public void createBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();
        bookDao.createBook(book);
    }

    @Override
    public List<Book> retrieveAllBooks() {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();
        return bookDao.retrieveAllBooks();
    }

    @Override
    public Book retrieveBook(Integer id) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();
        return bookDao.retrieveBook(id);
    }

    @Override
    public void updateBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();
        bookDao.deleteBook(book);
    }
}
