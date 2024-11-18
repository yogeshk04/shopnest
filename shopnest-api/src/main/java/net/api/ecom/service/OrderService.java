package net.api.ecom.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.api.ecom.dtos.OrderDto;
import net.api.ecom.entity.Order;
import net.api.ecom.exception.AppException;
import net.api.ecom.mappers.OrderMapper;
import net.api.ecom.repository.OrderRepository;

import java.util.Date;
import java.util.List;
// import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    /* @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    } */

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        //logger.info("Fetching all orders");
        List<Order> orders = orderRepository.findAll();
        //logger.info("Fetched orders: " + orders);
        return orderMapper.toOrderDtos(orders);
    }

    public OrderDto createOrders(OrderDto orderDto) {
        if (orderDto.getDate() == null) {
            orderDto.setDate(new Date());
        }
        Order order = orderMapper.toOrder(orderDto);
        order = orderRepository.save(order);        
        return orderMapper.toOrderDto(order);
    }

    public OrderDto updateOrder(int id, OrderDto orderDto) {
        Order order = orderRepository.findById(id)
            .orElseThrow(()-> new AppException("Order id not found", HttpStatus.NOT_FOUND));

        orderMapper.updateOrderRecord(order, orderMapper.toOrder(orderDto));

        Order updatedOrder = orderRepository.save(order);

        return orderMapper.toOrderDto(updatedOrder);
    }

    public OrderDto deleteOrder(int id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(()-> new AppException("Order id not found", HttpStatus.NOT_FOUND));

        OrderDto orderDto = orderMapper.toOrderDto(order);
        orderRepository.deleteById(id);
        return orderDto;
    }

    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(()-> new AppException("Order id not found", HttpStatus.NOT_FOUND));

        return orderMapper.toOrderDto(order);
    }

    public OrderDto patchOrder(int id, OrderDto orderDto) {
        Order order = orderRepository.findById(id)
            .orElseThrow(()-> new AppException("Order id not found", HttpStatus.NOT_FOUND));

        // if (orderDto.getDate() != null) {
        //     order.setDate(orderDto.getDate());
        // }

        orderMapper.updateOrderRecord(order, orderMapper.toOrder(orderDto));

        Order updatedOrder = orderRepository.save(order);

        return orderMapper.toOrderDto(updatedOrder);
    }
}
