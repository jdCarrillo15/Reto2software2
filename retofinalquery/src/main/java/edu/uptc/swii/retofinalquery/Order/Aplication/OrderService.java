package edu.uptc.swii.retofinalquery.Order.Aplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;
import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderEntity;
import edu.uptc.swii.retofinalquery.Order.Infrastructure.OrderPortMongo;

@Service
public class OrderService {
    @Autowired
    private OrderPortMongo orderPortMongo;

    public OrderService(OrderPortMongo orderPortMongo) {
        this.orderPortMongo = orderPortMongo;
    }

    public void createOrder(OrderEntity order) {
        orderPortMongo.saveCustomer(order);
    }

    public void updateOrder(OrderEntity order) {
        orderPortMongo.updateCustomer(order);
    }

    public List<Order> searchOrderByCustomerID(String customerid) {
        return orderPortMongo.getOrderByCustomerId(customerid);
    }
}
