package com.softserve.dao.impl;

import com.softserve.dao.AuthorDao;
import com.softserve.entity.Author;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=root";
    Connection connection;

    public AuthorDaoImpl() {
        connection = null;
        getConnection();
    }

    public void getConnection(){
        try {
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAuthor(Author author) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author (ID,FIRSTNAME,LASTNAME,AGE) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Element added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> retrieveAllAuthors() {
        List<Author> authors = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author");

            Author author;
            while (resultSet.next()) {
                author = new Author();
                author.setId(resultSet.getInt("ID"));
                author.setFirstName(resultSet.getString("FIRSTNAME"));
                author.setLastName(resultSet.getString("LASTNAME"));
                author.setAge(resultSet.getInt("AGE"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    @Override
    public Author retrieveAuthor(int id) {
        List<Author> authors = retrieveAllAuthors();
        Author author = null;
        for (Author b : authors) {
            if (b.getId() == id) {
                author = b;
                break;
            }
        }
        return author;
    }

    @Override
    public void updateAuthor(Author author) {
        String sql = "update author set FIRSTNAME = ?, LASTNAME = ?, AGE = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setInt(3, author.getAge());
            preparedStatement.setInt(4, author.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Author author) {
        String sql = "delete from author where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, author.getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
