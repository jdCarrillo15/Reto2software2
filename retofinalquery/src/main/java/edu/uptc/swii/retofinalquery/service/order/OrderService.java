package edu.uptc.swii.retofinalquery.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.domain.order.Order;
import edu.uptc.swii.retofinalquery.repository.OrderRepository;

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

    public List<Order> searchOrderByCustomerID(String customerID) {
        return orderRepository.findByCustomerID(customerID);
    }

}
