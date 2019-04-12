package com.softserve.dao;

import com.softserve.entity.ListOfAuthor;

import java.sql.SQLException;
import java.util.List;

public interface ListOfAuthorDao {

    void createListOfAuthor(ListOfAuthor listOfAuthor) throws SQLException;

    List<ListOfAuthor> retrieveAllListOfAuthor() throws SQLException;

    ListOfAuthor retrieveListOfAuthor(int id) throws SQLException;

    void updateListOfAuthor(ListOfAuthor listOfAuthor) throws SQLException;

    void deleteListOfAuthor(ListOfAuthor listOfAuthor);
}
