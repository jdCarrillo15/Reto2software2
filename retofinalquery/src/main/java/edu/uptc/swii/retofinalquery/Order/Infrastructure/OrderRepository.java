package edu.uptc.swii.retofinalquery.Order.Infrastructure;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository <OrderEntity, String> {
    List<OrderEntity> findBycustomerid(String customerid);
}
