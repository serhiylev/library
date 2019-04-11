package com.softserve.dao.impl;

import com.softserve.dao.BookDao;
import com.softserve.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=root";
    //public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    List<Book> books;
    Connection connection;

    public BookDaoImpl() {
        books = new ArrayList<>();
        connection = null;

        try {
            //Class.forName(DB_DRIVER);
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBook(Book book) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book (ID,NAME,RELEASE_DATA,AVAILABLE) VALUES (NULL,?,?,?)");
            //preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, book.getReleaseDate());
            preparedStatement.setBoolean(3, book.isAvailable());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Element added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> retrieveAllBooks() {
        List<Book> books = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            Book book;
            while (resultSet.next()) {
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
        List<Book> books = retrieveAllBooks();
        Book book = null;
        for (Book b : books) {
            if (b.getId() == id) {
                book = b;
                break;
            }
        }
        return book;
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update book set NAME = ?, RELEASE_DATE = ?, AVAILABLE = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, book.getReleaseDate());
            preparedStatement.setBoolean(3, book.isAvailable());
            preparedStatement.setInt(4, book.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "delete from book where ID = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,book.getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
