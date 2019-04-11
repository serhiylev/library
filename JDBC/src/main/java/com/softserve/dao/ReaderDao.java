package com.softserve.dao;

import com.softserve.entity.Reader;

import java.util.List;

public interface ReaderDao {
    void createReader(Reader reader);

    List<Reader> retrieveAllReaders();

    Reader retrieveReader(int id);

    void updateReader(Reader reader);

    void deleteReader(Reader reader);
}
