package com.softserve.dao.impl;

import com.softserve.dao.ReaderDao;
import com.softserve.entity.Reader;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
 public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=root&password=root2311";
    Connection connection;


    public void getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
    public void createReader(Reader reader) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reader (ID,FIRSTNAME,LASTNAME,AGE) VALUES (NULL,?,?,?)");
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setInt(3, reader.getAge());
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
    public List<Reader> retrieveAllReaders() {
        List<Reader> readers = new LinkedList<>();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reader");

            Reader reader;
            while (resultSet.next()) {
                reader = new Reader();
                reader.setId(resultSet.getInt("ID"));
                reader.setFirstName(resultSet.getString("FIRSTNAME"));
                reader.setLastName(resultSet.getString("LASTNAME"));
                reader.setAge(resultSet.getInt("AGE"));
                readers.add(reader);
            }
            resultSet.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("Connection error!");
            }
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
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getFirstName());
            preparedStatement.setString(2, reader.getLastName());
            preparedStatement.setInt(3, reader.getAge());
            preparedStatement.setInt(4, reader.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Database updated");
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
    public void deleteReader(Reader reader) {
        String sql = "delete from reader where ID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reader.getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted");
            connection.commit();
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
    public void deleteReaderById(Integer id) {
        String sql = "delete from reader where ID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
