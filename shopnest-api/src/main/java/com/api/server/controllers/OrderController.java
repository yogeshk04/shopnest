package com.api.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.api.server.dtos.OrderDto;
import com.api.server.service.OrderService;

import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDto> createOrder(@Validated @RequestBody OrderDto orderDto) {
        OrderDto createOrder = orderService.createOrders(orderDto);
        return ResponseEntity.created(URI.create("/api/orders/" + orderDto.getId())).body(createOrder);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable int id, @Validated @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderDto));
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
    
    // @Autowired
    // private OrderService orderService;

    // @GetMapping
    // public List<Order> getAllOrders() {
    //     return orderService.getAllOrders();
    // }

    // @PostMapping
    // public Order createOrder(@RequestBody Order order) {
    //     return orderService.saveOrder(order);
    // }
}
