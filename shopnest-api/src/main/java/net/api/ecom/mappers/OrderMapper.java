package net.api.ecom.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import net.api.ecom.dtos.OrderDto;
import net.api.ecom.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtos(List<Order> orders);

    @Mapping(target = "id", ignore = true)
    void updateOrderRecord(@MappingTarget Order target, Order source);
}
