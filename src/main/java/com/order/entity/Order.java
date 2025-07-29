package com.order.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @MongoId
    private Long orderId;

    @Indexed(name = "customerId_index")
    private Long customerId;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItem> orderItens;

    public Order() {
    }

    public Order(Long orderId,Long customerId, BigDecimal total, List<OrderItem> orderItens) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
        this.orderItens = orderItens;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItem> orderItens) {
        this.orderItens = orderItens;
    }
}
