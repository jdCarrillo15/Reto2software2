package edu.uptc.swii.retofinalcommand.Order.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.Order.Infrastructure.OrderEntity;
import edu.uptc.swii.retofinalcommand.Order.Infrastructure.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private OrderEventProducer orderEventProducer;
    private final String CREATE_ORDER_TOPIC = "create-order-topic";
    private final String UPDATE_ORDER_TOPIC = "update-order-topic";

    public OrderService(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }

    public void createOrder(OrderEntity order) {
        orderRepository.save(order);
        orderEventProducer.sendMessage(CREATE_ORDER_TOPIC, order);
    }

    public void updateOrder(OrderEntity order) {
        orderRepository.save(order);
        orderEventProducer.sendMessage(UPDATE_ORDER_TOPIC, order);
    }
}
