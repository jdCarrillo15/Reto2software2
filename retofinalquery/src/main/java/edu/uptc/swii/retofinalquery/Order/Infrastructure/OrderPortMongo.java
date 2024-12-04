package edu.uptc.swii.retofinalquery.Order.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;
import edu.uptc.swii.retofinalquery.Order.Domain.Status;

@Service
public class OrderPortMongo implements OrderAdapter {
    @Autowired
    private OrderRepository orderRepository;

    public OrderPortMongo(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveCustomer(OrderEntity orderEntity) {
        orderRepository.insert(orderEntity);
    }

    @Override
    public void updateCustomer(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    @Override
    public List<Order> getOrderByCustomerId(String customerid) {
        return orderEToOrder(orderRepository.findByCustomerid(customerid));
    }

    private List<Order> orderEToOrder(List<OrderEntity> orderEntities) {
        List<Order> orders = new ArrayList<Order>();
        for (OrderEntity orderEntity : orderEntities) {
            Order order = new Order(orderEntity.getOrderid(), orderEntity.getCustomerid(),
                    createStatus(orderEntity.getStatus()));
            orders.add(order);
        }
        return orders;
    }

    private Status createStatus(String statusString) {
        String[] statusCH = statusString.split("-");
        String status = statusCH[0];
        String statusDescription = statusCH[1].replace("_", " ");
        return new Status(status, statusDescription);
    }

}
