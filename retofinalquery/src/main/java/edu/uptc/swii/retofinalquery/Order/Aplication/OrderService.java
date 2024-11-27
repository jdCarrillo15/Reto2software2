package edu.uptc.swii.retofinalquery.Order.Aplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;
import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> searchOrderByCustomerID(String customerid) {
        return orderRepository.findByCustomerid(customerid);
    }

}
