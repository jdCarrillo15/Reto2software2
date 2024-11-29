package edu.uptc.swii.retofinalquery.Order.Aplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderEntity;
import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    public void updateOrder(OrderEntity order) {
        orderRepository.save(order);
    }

    public List<OrderEntity> searchOrderByCustomerID(String customerid) {
        return orderRepository.findByCustomerid(customerid);
    }

}
