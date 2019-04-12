package com.softserve.dao.impl;

import com.softserve.dao.OrderDao;
import com.softserve.entity.Book;
import com.softserve.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/library?user=root&password=admin";
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    List<Order> books;
    Connection connection;

    public OrderDaoImpl() {
        books = new ArrayList<>();
        connection = null;
        try {
            Class.forName(DB_DRIVER);
            if (connection == null)
                connection = DriverManager.getConnection(CONNECTION_STRING);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createOrder(Order order) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (ID,ID_READER,ID_BOOK,DATE_OF_ISSUANCE,DATE_OF_RETURN) VALUES (NULL,?,?,?,?)");
            preparedStatement.setInt(1, order.getId_reader());
            preparedStatement.setInt(2,order.getId_book() );
            preparedStatement.setDate(3, order.getDate_of_issuance());
            preparedStatement.setDate(4, order.getDate_of_return());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> retrieveAllOrders() {
        List<Order> orders = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM order");

            Order order;
            while (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("ID"));
                order.setId_reader(resultSet.getInt("ID_READER"));
                order.setId_book(resultSet.getInt("ID_BOOK"));
                order.setDate_of_issuance(resultSet.getDate("DATE_OF_ISSUANCE"));
                order.setDate_of_return(resultSet.getDate("DATE_OF_RETURN"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(books);
        return orders;
    }

    @Override
    public Order retrieveOrder(int id) {
        return null;
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }
}
