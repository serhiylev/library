package com.softserve.dao;

import com.softserve.entity.Reader;

import java.util.List;

public interface ReaderDao {
    void createBook(Reader reader);

    List<Reader> retrieveAllBooks();

    Reader retrieveBook(int id);

    void updateBook(Reader reader);

    void deleteBook(Reader reader);
}
