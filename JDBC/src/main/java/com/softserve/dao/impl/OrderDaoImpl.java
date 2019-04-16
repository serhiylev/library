package com.softserve.dao.impl;

import com.softserve.dao.OrderDao;
import com.softserve.entity.Book;
import com.softserve.entity.NewDate;
import com.softserve.entity.Order;
import com.softserve.entity.Reader;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=admin";
    Connection connection;

    private void getConnection() {
        try {
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrder(Order order) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO order (ID,ID_READER,ID_BOOK,DATE_OF_ISSUANCE,DATE_OF_RETURN) VALUES (NULL,?,?,?,?)");
            preparedStatement.setInt(1, order.getReader().getId());
            preparedStatement.setInt(2, order.getBook().getId());
            preparedStatement.setDate(3, order.getDateOfIssuance());
            preparedStatement.setDate(4, order.getDateOfReturn());
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
    public List<Order> retrieveAllOrders() {
        List<Order> orders = new LinkedList<>();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM order");
            Order order;
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("ID"));
                Reader reader = new ReaderDaoImpl().retrieveReader(resultSet.getInt("ID_READER"));
                Book book = new BookDaoImpl().retrieveBook(resultSet.getInt("ID_BOOK"));
                order.setReader(reader);
                order.setBook(book);
                order.setDateOfIssuance((NewDate) resultSet.getDate("DATE_OF_ISSUANCE"));
                order.setDateOfReturn((NewDate) resultSet.getDate("DATE_OF_RETURN"));
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
        return orders;
    }

    @Override
    public Order retrieveOrder(int id) {
        Order order = null;
        List<Order> orders = retrieveAllOrders();
        getConnection();
        for (Order o : orders) {
            if (o.getId() == id) {
                order = o;
                break;
            }
        }
        return order;
    }


    @Override
    public void updateOrder(Order order) {
        String sql = "update order set ID_READER = ?, ID_BOOK = ?, DATE_OF_ISSUANCE = ?, DATE_OF_RETURN = ? where ID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getReader().getId());
            preparedStatement.setInt(2, order.getBook().getId());
            preparedStatement.setDate(3, order.getDateOfIssuance());
            preparedStatement.setDate(4, order.getDateOfReturn());
            preparedStatement.setInt(5, order.getId());
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
    public void deleteOrder(Order order) {
        String sql = "delete from order where ID = ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getId());
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

