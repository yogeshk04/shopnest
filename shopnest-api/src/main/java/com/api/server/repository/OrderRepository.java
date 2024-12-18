package com.api.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.server.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
