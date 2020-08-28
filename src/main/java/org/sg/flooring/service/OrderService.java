package org.sg.flooring.service;

import org.sg.flooring.dtos.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    boolean addOrder(Order order);

    List<Order> getOrders();

    Order findOrderByDate(LocalDate date);

    Order findOrderById(long orderId);

    void deleteOrder(long orderId);

    void saveOrder(Order order);
}
