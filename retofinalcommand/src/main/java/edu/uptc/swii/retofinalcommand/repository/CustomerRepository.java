package edu.uptc.swii.retofinalcommand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uptc.swii.retofinalcommand.domain.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    
}
