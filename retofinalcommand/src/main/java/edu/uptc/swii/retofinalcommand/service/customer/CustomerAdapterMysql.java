package edu.uptc.swii.retofinalcommand.service.customer;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uptc.swii.retofinalcommand.domain.customer.Customer;
import edu.uptc.swii.retofinalcommand.repository.CustomerRepository;

public class CustomerAdapterMysql implements CustomerPort {
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
}
