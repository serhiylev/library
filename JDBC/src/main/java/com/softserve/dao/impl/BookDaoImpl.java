package com.softserve.dao.impl;

import com.softserve.dao.BookDao;
import com.softserve.entity.Book;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/library?user=root&password=root";

    private Connection connection;

    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void createBook(Book book) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book (ID,NAME,RELEASE_DATE,AVAILABLE) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, book.getReleaseDate());
            preparedStatement.setBoolean(3, book.isAvailable());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
            System.out.println("Element added");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Connection error!");
            }
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
                books.add(book);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book retrieveBook(int id) {
        Book book = null;
        List<Book> books = retrieveAllBooks();
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
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDate(2, book.getReleaseDate());
            preparedStatement.setBoolean(3, book.isAvailable());
            preparedStatement.setInt(4, book.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Connection error!");
            }
        }
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "delete from book where NAME = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Record deleted successfully");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Connection error!");
            }
            e.printStackTrace();
        }
    }
}
