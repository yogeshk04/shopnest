package com.api.server.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.api.server.dtos.OrderDto;
import com.api.server.entity.Order;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtos(List<Order> orders);

    @Mapping(target = "id", ignore = true)
    void updateOrderRecord(@MappingTarget Order target, Order source);
}
