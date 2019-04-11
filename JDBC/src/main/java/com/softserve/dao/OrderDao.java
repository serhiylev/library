package com.softserve.dao;

import com.softserve.entity.Book;
import com.softserve.entity.Order;

import java.util.List;

public interface OrderDao {

    void createOrder(Order order);

    List<Order> retrieveAllOrders();

    Order retrieveOrder(int id);

    void updateOrder(Order order);

    void deleteOrder(Order order);

}
