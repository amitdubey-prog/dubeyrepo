package com.edureka.orderms.resource;

import com.edureka.orderms.model.Order;
import com.edureka.orderms.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class OrderResource {

    private final OrderService orderService;

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllOrders() {
        log.info("Getting all orders");
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping(path = "/orders/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSingleOrder(@PathVariable Long orderId) {
        log.info("Getting single order");
        final Optional<Order> userOptional = orderService.getSingleOrder(orderId);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

}
