package com.softserve.dao.impl;

import com.softserve.entity.ListOfAuthor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListOfAuthorDaoImplTest {

    @Test
    public void retrieveAllListOfAuthor() {
        ListOfAuthorDaoImpl listOfAuthorDao = new ListOfAuthorDaoImpl();
        listOfAuthorDao.getConnection();
        List<ListOfAuthor> listOfAuthors = listOfAuthorDao.retrieveAllListOfAuthor();
        for(ListOfAuthor l:listOfAuthors){
            System.out.println(l.getId()+"  "+l.getBook().getName()+"  "+l.getAuthor().getFirstName()+"  "+l.getAuthor().getLastName());
        }
    }
}