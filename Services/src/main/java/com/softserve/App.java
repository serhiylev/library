package com.softserve;

import com.softserve.controllers.BookService;
import com.softserve.controllers.impl.BookServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookService bookController = new BookServiceImpl();
        System.out.println(bookController.retrieveBook(3));
        System.out.println(bookController.retrieveAllBooks());
    }
}
