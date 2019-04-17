package com.softserve.dao.impl;

import com.softserve.dao.ListOfAuthorDao;
import com.softserve.entity.Author;
import com.softserve.entity.Book;
import com.softserve.entity.ListOfAuthor;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ListOfAuthorDaoImpl implements ListOfAuthorDao {
 public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/library?user=root&password=root";
    Connection connection;

    public ListOfAuthorDaoImpl(){
        getConnection();
    }


    public void getConnection() {
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO list_of_author (ID,ID_AUTHOR,BOOK_ID,MAIN_AUTHOR) VALUES (NULL,?,?,?)");
            preparedStatement.setInt(1, listOfAuthor.getAuthor().getId());
            preparedStatement.setInt(2, listOfAuthor.getBook().getId());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Element added");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<ListOfAuthor> retrieveAllListOfAuthor() {
        List<ListOfAuthor> listOfAuthors = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM list_of_author;");
            ListOfAuthor listOfAuthor;
            while (resultSet.next()) {
                listOfAuthor = new ListOfAuthor();
                listOfAuthor.setId(resultSet.getInt("ID"));
                listOfAuthor.setMain_author(resultSet.getInt("MAIN_AUTHOR"));

                BookDaoImpl bookDao = new BookDaoImpl();
                Book template = bookDao.retrieveBook(resultSet.getInt("BOOK_ID"));

                AuthorDaoImpl authorDao = new AuthorDaoImpl();
                Author author = authorDao.retrieveAuthor(resultSet.getInt("ID_AUTHOR"));

                listOfAuthor.setAuthor(author);
                listOfAuthor.setBook(template);
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
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getAuthor().getId());
            preparedStatement.setInt(2, listOfAuthor.getBook().getId());
            preparedStatement.setInt(3, listOfAuthor.getMain_author());
            preparedStatement.setInt(4, listOfAuthor.getId());
            preparedStatement.executeUpdate();
            System.out.println("Database updated successfully");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void deleteListOfAuthor(ListOfAuthor listOfAuthor){
        String sql = "delete from list_of_author where BOOK_ID = ? AND ID_AUTHOR = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listOfAuthor.getBook().getId());
            preparedStatement.setInt(2, listOfAuthor.getAuthor().getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
