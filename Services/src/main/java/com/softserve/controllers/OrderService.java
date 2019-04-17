package com.softserve.controllers;

import com.softserve.entity.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    List<Order> retrieveAllOrders();

    Order retrieveOrder(Integer id);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    void deleteOrderById(int id);

    void deleteOrderByIdReader(int id_reader);
}
