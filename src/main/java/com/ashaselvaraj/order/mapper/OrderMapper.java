package com.ashaselvaraj.order.mapper;

import com.ashaselvaraj.order.dto.OrderDTO;
import com.ashaselvaraj.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper Instance = Mappers.getMapper(OrderMapper.class);

    OrderDTO getOrderDtoFromOrder(Order order);

    Order getOrderFromOrderDto(OrderDTO orderDTO);
}
