package edu.uptc.swii.retofinalquery.service.customer;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;
import edu.uptc.swii.retofinalquery.repository.CustomerRepository;


public class CustomerAdapterMongo implements CustomerPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByDocument(String document) {
        return customerRepository.findById(document).get();
        }
}
