package com.order.mapper;

import com.order.dto.OrderCreatedDTO;
import com.order.response.OrderResponse;
import com.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order DtoToEntity(OrderCreatedDTO orderCreatedDTO);

    OrderResponse entityToDto(Order order);
}
