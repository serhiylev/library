package com.softserve;

import com.softserve.dao.impl.BookDaoImpl;
import com.softserve.entity.Book;

/**
 * Hello world!
 */
public class App {

    public static Book bookTemplate;


    public static void main(String[] args) {
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.getConnection();

        System.out.println(bookDao.retrieveBook(3));
    }
}
