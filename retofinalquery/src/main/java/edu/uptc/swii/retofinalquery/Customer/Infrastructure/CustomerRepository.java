package edu.uptc.swii.retofinalquery.Customer.Infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    
}
