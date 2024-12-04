package edu.uptc.swii.retofinalquery.Order.Infrastructure;

import java.util.List;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;

public interface OrderAdapter {
    void saveCustomer(OrderEntity orderEntity);

    void updateCustomer(OrderEntity orderEntity);

    List<Order> getOrderByCustomerId(String customerid);
}
