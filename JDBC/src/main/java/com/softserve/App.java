package com.softserve;

import com.softserve.dao.impl.BookDaoImpl;
import com.softserve.entity.Book;

import java.sql.Date;

/**
 * Hello world!
 */
public class App {

    public static Book bookTemplate;


    public static void main(String[] args) {

        /*bookTemplate = new Book();
        //Date date = new Date(2007,6, 17);
        //bookTemplate.setId(20);
        bookTemplate.setName("MyBook");
        bookTemplate.setReleaseDate(date);
        bookTemplate.setAvailable(true);
*/

        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.retrieveBook(3);
        System.out.println(bookDao.retrieveBook(3));


    }
}
