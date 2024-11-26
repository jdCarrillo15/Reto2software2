package edu.uptc.swii.retofinalquery.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
