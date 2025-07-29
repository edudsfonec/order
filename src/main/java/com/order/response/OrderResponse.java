package com.order.response;

import java.math.BigDecimal;

public class OrderResponse {

    private Long orderId;

    private Long customerId;

    private BigDecimal total;

    public OrderResponse(Long orderId, Long customerId, BigDecimal total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
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
}
