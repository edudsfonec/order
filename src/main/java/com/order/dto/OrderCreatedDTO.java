package com.order.dto;

import java.util.List;

public class OrderCreatedDTO {

    private Long orderId;

    private Long customerId;

    private List<OrderItemDTO> orderItens;

    public OrderCreatedDTO() {
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

    public List<OrderItemDTO> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItemDTO> orderItens) {
        this.orderItens = orderItens;
    }
}
