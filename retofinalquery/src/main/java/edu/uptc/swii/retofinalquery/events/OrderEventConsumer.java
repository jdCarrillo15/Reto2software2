package edu.uptc.swii.retofinalquery.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import edu.uptc.swii.retofinalquery.domain.order.Order;
import edu.uptc.swii.retofinalquery.service.order.OrderService;
import edu.uptc.swii.retofinalquery.utils.JsonUtils;

public class OrderEventConsumer {
    @Autowired
    private OrderService OrderService;

    @KafkaListener(topics = "add-order-topic", groupId = "order-group")
    public void addOrderConsume(String message) {
        message = message.replace("\\", "");
        message = message.substring(1, message.length() - 1);
        System.out.println("Add order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        Order savedOrder = jsonUtils.fromJson(message, Order.class);
        OrderService.createOrder(savedOrder);

    }

    @KafkaListener(topics = "update-order-topic", groupId = "order-group")
    public void updateOrderConsume(String message) {
        System.out.println("Update order - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        Order savedOrder = jsonUtils.fromJson(message, Order.class);
        OrderService.updateOrder(savedOrder);
    }
}
