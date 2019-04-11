package com.softserve.dao.impl;

import com.softserve.dao.ReaderDao;
import com.softserve.entity.Reader;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=root";
    Connection connection;

    public ReaderDaoImpl() {
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
    public void createReader(Reader reader) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reader (ID,FIRSTNAME,LASTNAME,AGE) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setInt(3, reader.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Element added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reader> retrieveAllReaders() {
        List<Reader> readers = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reader");

            Reader reader;
            while (resultSet.next()) {
                reader = new Reader();
                reader.setId(resultSet.getInt("ID"));
                reader.setFirstName(resultSet.getString("FIRSTNAME"));
                reader.setLastName(resultSet.getString("LASTNAME"));
                reader.setAge(resultSet.getInt("AGE"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readers;
    }

    @Override
    public Reader retrieveReader(int id) {
        List<Reader> readers = retrieveAllReaders();
        Reader reader = null;
        for (Reader b : readers) {
            if (b.getId() == id) {
                reader = b;
                break;
            }
        }
        return reader;
    }

    @Override
    public void updateReader(Reader reader) {
        String sql = "update reader set FIRSTNAME = ?, LASTNAME = ?, AGE = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setInt(3, reader.getAge());
            preparedStatement.setInt(4, reader.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReader(Reader reader) {
        String sql = "delete from reader where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reader.getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
