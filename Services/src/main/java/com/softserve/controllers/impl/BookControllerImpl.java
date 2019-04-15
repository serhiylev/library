package com.softserve.controllers.impl;

import com.softserve.controllers.BookController;
import com.softserve.dao.BookDao;
import com.softserve.dao.impl.BookDaoImpl;
import com.softserve.entity.Book;

import java.util.List;

public class BookControllerImpl implements BookController {
    @Override
    public void createBook(Book book) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();

    }

    @Override
    public List<Book> retrieveAllBooks() {
        return null;
    }

    @Override
    public Book retrieveBook(Integer id) {
        return null;
    }

    @Override
    public void updateBook(Book book) {
        return;
    }

    @Override
    public void deleteBook(Book book) {

    }
}
