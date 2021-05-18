package com.edureka.orderms.service;

import com.edureka.orderms.model.Order;
import com.edureka.orderms.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        log.info("Getting all orders");
        return orderRepository.findAll();
    }

    public Optional<Order> getSingleOrder(Long orderId) {
        log.info("Getting all orders");
        return orderRepository.findById(orderId);
    }
}
