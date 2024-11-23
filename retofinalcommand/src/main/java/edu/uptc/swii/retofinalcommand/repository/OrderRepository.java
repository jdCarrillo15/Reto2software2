package edu.uptc.swii.retofinalcommand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uptc.swii.retofinalcommand.domain.order.Order;

public interface OrderRepository extends JpaRepository <Order, String> {
    
}
