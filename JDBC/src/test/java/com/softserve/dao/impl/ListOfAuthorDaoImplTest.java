package com.softserve.dao.impl;

import com.softserve.dao.ListOfAuthorDao;
import com.softserve.entity.ListOfAuthor;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ListOfAuthorDaoImplTest {

    @Test
    public void createListOfAuthor() {
        ListOfAuthor listOfAuthor = new ListOfAuthor();
        listOfAuthor.setId(1);
        listOfAuthor.;
        listOfAuthor.setId_author(4);
        listOfAuthor.setMain_author(1);
        ListOfAuthorDao listOfAuthorDao = new ListOfAuthorDaoImpl();
        listOfAuthorDao.createListOfAuthor(listOfAuthor);
    }

    @Test
    public void retrieveAllBooks() {
        List<ListOfAuthor> listOfAuthors;
        ListOfAuthorDao listOfAuthorDao = new ListOfAuthorDaoImpl();
        listOfAuthors = listOfAuthorDao.retrieveAllBooks();
        System.out.println(listOfAuthors);
    }

    @Test
    public void retrieveBook() {
        ListOfAuthor listOfAuthor = (new ListOfAuthorDaoImpl().retrieveBook(3));
        System.out.println(listOfAuthor);
    }

    @Test
    public void updateBook() {
        ListOfAuthor listOfAuthor = new ListOfAuthor();
        listOfAuthor.setId(22);
        listOfAuthor.setBook_id(6);
        listOfAuthor.setId_author(7);
        listOfAuthor.setMain_author(1);

        ListOfAuthorDao listOfAuthorDao = new ListOfAuthorDaoImpl();
        listOfAuthorDao.updateBook(listOfAuthor);
        listOfAuthor.setId_author(6);
        listOfAuthorDao.updateBook(listOfAuthor);

    }

    @Test
    public void deleteBook() {
        ListOfAuthor listOfAuthor = new ListOfAuthor();
        listOfAuthor.setId(1);
        listOfAuthor.setBook_id(6);
        listOfAuthor.setId_author(6);
        listOfAuthor.setMain_author(1);

        ListOfAuthorDao listOfAuthorDao = new ListOfAuthorDaoImpl();
        listOfAuthorDao.deleteBook(listOfAuthor);
    }
}