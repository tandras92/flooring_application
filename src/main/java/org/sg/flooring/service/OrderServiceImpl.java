package org.sg.flooring.service;

import org.sg.flooring.dtos.Order;
import org.sg.flooring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("orderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private OrderDao orderDao;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean addOrder(Order order) {
        orderRepository.save(order);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderByDate(LocalDate date) {
        return orderRepository.findOrderByDate(date);
    }

    @Override
    public Order findOrderById(long orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteOrderByOrderId(orderId);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
