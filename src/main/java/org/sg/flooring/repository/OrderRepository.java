package org.sg.flooring.repository;

import org.sg.flooring.dtos.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderByDate(LocalDate date);

    Order findOrderByOrderId(long orderId);

    void deleteOrderByOrderId(long orderId);
}
