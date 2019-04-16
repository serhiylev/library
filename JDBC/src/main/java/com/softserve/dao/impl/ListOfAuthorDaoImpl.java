package com.softserve.dao.impl;

import com.softserve.dao.ListOfAuthorDao;
import com.softserve.entity.Author;
import com.softserve.entity.Book;
import com.softserve.entity.ListOfAuthor;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ListOfAuthorDaoImpl implements ListOfAuthorDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=root&password=root2311";
    Connection connection;

    private void getConnection() {
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
    public void createListOfAuthor(ListOfAuthor listOfAuthor) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO list_of_author (ID,ID_AUTHOR,BOOK_ID,MAIN_AUTHOR) VALUES (NULL,?,?,?)");
            preparedStatement.setInt(1, listOfAuthor.getAuthor().getId());
            preparedStatement.setInt(2, listOfAuthor.getBook().getId());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Element added");
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
    public List<ListOfAuthor> retrieveAllListOfAuthor() {
        List<ListOfAuthor> listOfAuthors = new LinkedList<>();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM list_of_author ");
            ListOfAuthor listOfAuthor;
            while (resultSet.next()) {
                listOfAuthor = new ListOfAuthor();
                listOfAuthor.setId(resultSet.getInt("ID"));
                listOfAuthor.setMain_author(resultSet.getInt("MAIN_AUTHOR"));
                Book template = new BookDaoImpl().retrieveBook(resultSet.getInt("BOOK_ID"));
                Author author = new AuthorDaoImpl().retrieveAuthor(resultSet.getInt("ID_AUTHOR"));
                listOfAuthor.setAuthor(author);
                listOfAuthor.setBook(template);
                listOfAuthors.add(listOfAuthor);
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
        return listOfAuthors;
    }

    @Override
    public ListOfAuthor retrieveListOfAuthor(int id) {
        ListOfAuthor result = new ListOfAuthor();
        List<ListOfAuthor> listOfAuthors = retrieveAllListOfAuthor();
        for (ListOfAuthor l : listOfAuthors) {
            result = l.getId() == id ? l : result;
        }
        return result;
    }

    @Override
    public void updateListOfAuthor(ListOfAuthor listOfAuthor) {
        String sql = "update list_of_author set ID_AUTHOR = ?, BOOK_ID = ?, MAIN_AUTHOR = ? where ID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getAuthor().getId());
            preparedStatement.setInt(2, listOfAuthor.getBook().getId());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.setInt(4, listOfAuthor.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
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
    public void deleteListOfAuthor(ListOfAuthor listOfAuthor){
        String sql = "delete from list_of_author where BOOK_ID = ? AND ID_AUTHOR = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getBook().getId());
            preparedStatement.setInt(2, listOfAuthor.getAuthor().getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
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
}
