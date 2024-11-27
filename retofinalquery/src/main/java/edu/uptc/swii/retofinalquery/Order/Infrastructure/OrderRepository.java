package edu.uptc.swii.retofinalquery.Order.Infrastructure;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;

public interface OrderRepository extends MongoRepository <Order, String> {
    List<Order> findByCustomerid(String customerid);
}
