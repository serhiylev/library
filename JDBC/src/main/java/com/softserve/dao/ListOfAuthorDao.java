package com.softserve.dao;

import com.softserve.entity.ListOfAuthor;

import java.util.List;

public interface ListOfAuthorDao {

    void createListOfAuthor(ListOfAuthor listOfAuthor);

    List<ListOfAuthor> retrieveAllListOfAuthor();

    ListOfAuthor retrieveListOfAuthor(int id);

    void updateListOfAuthor(ListOfAuthor listOfAuthor);

    void deleteListOfAuthor(ListOfAuthor listOfAuthor);
}
