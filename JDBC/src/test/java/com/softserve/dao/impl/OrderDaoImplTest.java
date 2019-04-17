package com.softserve.dao.impl;

import com.softserve.entity.Book;
import com.softserve.entity.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void deleteOrder() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
//        Order order = new Order();
//        order.setId(1);
//        orderDao.deleteOrder(order);

        System.out.println(orderDao.retrieveAllOrders());
    }
}