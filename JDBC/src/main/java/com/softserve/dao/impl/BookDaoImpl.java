package com.softserve.dao.impl;

import com.softserve.dao.BookDao;
import com.softserve.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=root";
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    List<Book> books;
    Connection connection;

    public BookDaoImpl() {
        books = new ArrayList<>();
        connection = null;
    }

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public List<Book> retrieveAllBooks() {
        return null;
    }

    @Override
    public Book retrieveBook(int id) {
        return null;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }
}
