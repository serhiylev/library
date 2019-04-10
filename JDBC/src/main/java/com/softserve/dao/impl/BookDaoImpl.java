package com.softserve.dao.impl;

import com.softserve.dao.BookDao;
import com.softserve.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (ID,NAME,RELEASE_DATA,AVAILABLE) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1,book.getName());
            preparedStatement.setDate(2,book.getReleaseDate());
            preparedStatement.setBoolean(3,book.isAvailable());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> retrieveAllBooks() {
        List<Book> books = new LinkedList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            Book book = null;
            while(resultSet.next()){
                book = new Book();
                book.setId(resultSet.getInt("ID"));
                book.setName(resultSet.getString("NAME"));
                book.setReleaseDate(resultSet.getDate("RELEASE_DATE"));
                book.setAvailable(resultSet.getBoolean("AVAILABLE"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(books);
        return books;
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
