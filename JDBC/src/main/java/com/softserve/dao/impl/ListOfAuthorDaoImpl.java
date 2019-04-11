package com.softserve.dao.impl;

import com.softserve.dao.ListOfAuthorDao;
import com.softserve.entity.ListOfAuthor;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ListOfAuthorDaoImpl implements ListOfAuthorDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=root";
    Connection connection;

    public ListOfAuthorDaoImpl() {
        getConnection();
    }

    private void getConnection() {
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
            getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO list_of_author (ID,ID_AUTHOR,BOOK_ID,MAIN_AUTHOR) VALUES (NULL,?,?,?)");
            preparedStatement.setInt(1, listOfAuthor.getId_author());
            preparedStatement.setInt(2, listOfAuthor.getBook_id());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Element added");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ListOfAuthor> retrieveAllBooks() {
        List<ListOfAuthor> listOfAuthors = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM list_of_author ");
            ListOfAuthor listOfAuthor;

            while (resultSet.next()) {
                listOfAuthor = new ListOfAuthor();
                listOfAuthor.setId(resultSet.getInt("ID"));
                listOfAuthor.setId_author(resultSet.getInt("ID_AUTHOR"));
                listOfAuthor.setBook_id(resultSet.getInt("BOOK_ID"));
                listOfAuthor.setMain_author(resultSet.getInt("MAIN_AUTHOR"));
                listOfAuthors.add(listOfAuthor);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAuthors;
    }

    @Override
    public ListOfAuthor retrieveBook(int id) {
        ListOfAuthor result = new ListOfAuthor();
        List<ListOfAuthor> listOfAuthors = retrieveAllBooks();

        for (ListOfAuthor l : listOfAuthors) {
            result = l.getId() == id ? l : result;
        }
        return result;
    }

    @Override
    public void updateBook(ListOfAuthor listOfAuthor) {
        String sql = "update list_of_author set ID_AUTHOR = ?, BOOK_ID = ?, MAIN_AUTHOR = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getId_author());
            preparedStatement.setInt(2, listOfAuthor.getBook_id());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.setInt(4, listOfAuthor.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(ListOfAuthor listOfAuthor) {
        String sql = "delete from list_of_author where BOOK_ID = ? AND ID_AUTHOR = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getBook_id());
            preparedStatement.setInt(2, listOfAuthor.getId_author());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
