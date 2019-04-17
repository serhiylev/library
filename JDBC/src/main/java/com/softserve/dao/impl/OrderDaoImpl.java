package com.softserve.dao.impl;

import com.softserve.dao.OrderDao;
import com.softserve.entity.Book;
import com.softserve.entity.Order;
import com.softserve.entity.Reader;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/library?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&user=root&password=admin";
    Connection connection;

    public OrderDaoImpl(){
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
    public void createOrder(Order order) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (ID,ID_READER,ID_BOOK,DATE_OF_ISSUANCE,DATE_OF_RETURN) VALUES (NULL,?,?,?,?)");
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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
            Order order;
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("ID"));

                Reader reader = new ReaderDaoImpl().retrieveReader(resultSet.getInt("ID_READER"));
                Book book = new BookDaoImpl().retrieveBook(resultSet.getInt("ID_BOOK"));
                order.setReader(reader);
                order.setBook(book);
                order.setDateOfIssuance(resultSet.getDate("DATE_OF_ISSUANCE"));
                order.setDateOfReturn(resultSet.getDate("DATE_OF_RETURN"));
                orders.add(order);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order retrieveOrder(int id) {
        Order order = null;
        List<Order> orders = retrieveAllOrders();
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
        String sql = "update orders set ID_READER = ?, ID_BOOK = ?, DATE_OF_ISSUANCE = ?, DATE_OF_RETURN = ? where ID = ?";
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
        String sql = "delete from orders where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getId());
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

