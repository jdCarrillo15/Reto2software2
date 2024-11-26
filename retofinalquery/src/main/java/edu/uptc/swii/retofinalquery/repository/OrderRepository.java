package edu.uptc.swii.retofinalquery.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uptc.swii.retofinalquery.domain.order.Order;

public interface OrderRepository extends MongoRepository <Order, String> {
    List<Order> findByCustomerID(String customerID);
}
