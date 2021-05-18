package com.edureka.orderms.repository;

import com.edureka.orderms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Default CRUD operations
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
