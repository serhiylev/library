package com.softserve.dao;

import com.softserve.entity.Book;
import com.softserve.entity.ListOfAuthor;

import java.util.List;

public interface ListOfAuthorDao {

    void createListOfAuthor(ListOfAuthor listOfAuthor);

    List<ListOfAuthor> retrieveAllBooks();

    ListOfAuthor retrieveBook(int id);

    void updateBook(ListOfAuthor listOfAuthor);

    void deleteBook(ListOfAuthor listOfAuthor);
}
