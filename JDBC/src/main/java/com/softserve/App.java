package com.softserve;

import com.softserve.addition.NewDate;
import com.softserve.dao.impl.BookDaoImpl;
import com.softserve.entity.Book;

import java.math.BigInteger;
import java.sql.Date;


/**
 * Hello world!
 */
public class App {

    public static Book bookTemplate;


    public static void main(String[] args) {
///////////////////////////////////////////////////////////////////
        /*bookTemplate = new Book();
        NewDate date = new NewDate(2017,0,14);
        bookTemplate.setId(5);
        bookTemplate.setName("MyBook");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.updateBook(bookTemplate);*/
///////////////////////////////////////////////////////////////////
        /*BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.retrieveBook(3);
        System.out.println(bookDao.retrieveAllBooks());*/
///////////////////////////////////////////////////////////////////
/*        NewDate date = new NewDate(2017,0,14);
        bookTemplate = new Book();
        bookTemplate.setId(2);
        bookTemplate.setName("MyBook2");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.createBook(bookTemplate);*/
///////////////////////////////////////////////////////////////////
/*
        NewDate date = new NewDate(2017,0,14);
        bookTemplate = new Book();
        bookTemplate.setName("MyBook2");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.deleteBook(bookTemplate);
*/
//////////////////////////////////////////////////////////////////
    }
}
