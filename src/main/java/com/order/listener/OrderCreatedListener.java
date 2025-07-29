package com.order.listener;

import com.order.dto.OrderCreatedDTO;
import com.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.order.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    private final OrderService orderService;
    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedDTO> message) {
        logger.info("Message received: {}", message);
        orderService.save(message.getPayload());
    }
}
