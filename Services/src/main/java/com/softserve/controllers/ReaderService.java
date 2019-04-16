package com.softserve.controllers;

import com.softserve.entity.Reader;

import java.util.List;

public interface ReaderService {
    void createReader(Reader reader);

    List<Reader> retrieveAllReaders();

    Reader retrieveReader(Integer id);

    void updateReader(Reader reader);

    void deleteReader(Reader reader);

    void deleteReaderById(int id);
}
