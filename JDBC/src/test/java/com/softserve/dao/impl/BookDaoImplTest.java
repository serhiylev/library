package com.softserve.dao.impl;

import com.softserve.addition.NewDate;
import com.softserve.entity.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    Book bookTemplate;

    @Test
    public void createBook() {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookTemplate = new Book();
        NewDate date = new NewDate(2017,0,14);
        bookTemplate.setId(5);
        bookTemplate.setName("My life");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        bookDao.createBook(bookTemplate);
    }

    @Test
    public void retrieveAllBooks() {
        System.out.println(new BookDaoImpl().retrieveAllBooks());
    }

    @Test
    public void retrieveBook() {
        BookDaoImpl bookDao = new BookDaoImpl();

        System.out.println(bookDao.retrieveBook(3));
        System.out.println(bookDao.retrieveBook(2));
        System.out.println(bookDao.retrieveBook(1));
    }

    @Test
    public void updateBook() {
        bookTemplate = new Book();
        NewDate date = new NewDate(2017,0,14);
        bookTemplate.setId(14);
        bookTemplate.setName("My home");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.updateBook(bookTemplate);
    }

    @Test
    public void deleteBook() {
        bookTemplate = new Book();
        NewDate date = new NewDate(2017,0,14);
        bookTemplate.setId(14);
        bookTemplate.setName("My home");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.deleteBook(bookTemplate);
    }
}