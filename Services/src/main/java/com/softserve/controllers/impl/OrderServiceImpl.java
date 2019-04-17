package com.softserve.controllers.impl;

import com.softserve.controllers.OrderService;
import com.softserve.dao.impl.OrderDaoImpl;
import com.softserve.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(Order order) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        orderDao.createOrder(order);
    }

    @Override
    public List<Order> retrieveAllOrders() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        return orderDao.retrieveAllOrders();
    }

    @Override
    public Order retrieveOrder(Integer id) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        return orderDao.retrieveOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        orderDao.deleteOrder(order);
    }

    @Override
    public void deleteOrderById(int id) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        orderDao.deleteOrderById(id);
    }

    @Override
    public void deleteOrderByIdReader(int id_reader){
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.getConnection();
        orderDao.deleteOrderByIdReader(id_reader);
    }
}
