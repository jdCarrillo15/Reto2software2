package edu.uptc.swii.retofinalquery.Customer.Infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPortMongo implements CustomerAdapter {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    public CustomerEntity getCustomerByDocument(String document) {
        return customerRepository.findById(document).get();
    }
}
