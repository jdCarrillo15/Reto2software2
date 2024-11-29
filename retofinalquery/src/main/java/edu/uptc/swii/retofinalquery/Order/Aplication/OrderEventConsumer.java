package edu.uptc.swii.retofinalquery.Order.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderEntity;
import edu.uptc.swii.retofinalquery.utils.JsonUtils;

public class OrderEventConsumer {
    @Autowired
    private OrderService OrderService;

    @KafkaListener(topics = "create-order-topic", groupId = "order-group")
    public void addOrderConsume(String message) {
        message = message.replace("\\", "");
        message = message.substring(1, message.length() - 1);
        System.out.println("Add order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        OrderEntity savedOrder = jsonUtils.fromJson(message, OrderEntity.class);
        OrderService.createOrder(savedOrder);

    }

    @KafkaListener(topics = "update-order-topic", groupId = "order-group")
    public void updateOrderConsume(String message) {
        System.out.println("Update order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        OrderEntity savedOrder = jsonUtils.fromJson(message, OrderEntity.class);
        OrderService.updateOrder(savedOrder);
    }
}
