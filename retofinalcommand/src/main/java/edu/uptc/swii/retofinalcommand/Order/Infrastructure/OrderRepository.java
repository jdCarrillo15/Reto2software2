package edu.uptc.swii.retofinalcommand.Order.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <OrderEntity, String> {
    
}
