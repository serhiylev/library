package com.softserve.controllers.impl;

import com.softserve.controllers.ReaderService;
import com.softserve.dao.impl.ReaderDaoImpl;
import com.softserve.entity.Reader;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public void createReader(Reader reader) {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        readerDao.createReader(reader);
    }

    @Override
    public List<Reader> retrieveAllReaders() {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        return readerDao.retrieveAllReaders();
    }

    @Override
    public Reader retrieveReader(Integer id) {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        return readerDao.retrieveReader(id);
    }

    @Override
    public void updateReader(Reader reader) {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        readerDao.updateReader(reader);
    }

    @Override
    public void deleteReader(Reader reader) {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        readerDao.deleteReader(reader);
    }

    @Override
    public void deleteReaderById(int id) {
        ReaderDaoImpl readerDao = new ReaderDaoImpl();
        readerDao.getConnection();
        readerDao.deleteReaderById(id);
    }
}
