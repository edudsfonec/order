package com.order.mapper;

import com.order.dto.OrderItemDTO;
import com.order.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem toEntity(OrderItemDTO orderItemDTO);
}
