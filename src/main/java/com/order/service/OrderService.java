package com.order.service;

import com.order.dto.OrderCreatedDTO;
import com.order.response.OrderResponse;
import com.order.entity.Order;
import com.order.mapper.OrderItemMapper;
import com.order.mapper.OrderMapper;
import com.order.repository.OrderRepository;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final MongoTemplate mongoTemplate;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, OrderItemMapper orderItemMapper, MongoTemplate mongoTemplate){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public Order save(OrderCreatedDTO orderCreatedDTO){
        BigDecimal total = calculateTotal(orderCreatedDTO);

        Order order = new Order(
                orderCreatedDTO.getOrderId(),
                orderCreatedDTO.getCustomerId(),
                total,
                orderCreatedDTO.getOrderItens()
                        .stream()
                        .map(orderItemDTO -> orderItemMapper.toEntity(orderItemDTO))
                        .collect(Collectors.toList())
        );

        return orderRepository.save(order);
    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest){
        Page<Order> orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(orderMapper::entityToDto);
    }

    public BigDecimal findTotalByCustomerId(Long customerId) {
        var aggregation = newAggregation(
                match(Criteria.where("customerId").is(customerId)),
                group().sum("total").as("total")
        );

         var response = mongoTemplate.aggregate(aggregation, "orders", Document.class);


         return new BigDecimal(response.getUniqueMappedResult().getOrDefault("total", BigDecimal.ZERO).toString());
    }

    private BigDecimal calculateTotal(OrderCreatedDTO order) {
        return order.getOrderItens()
                .stream()
                .map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
