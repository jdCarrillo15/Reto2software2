package edu.uptc.swii.retofinalcommand.Customer.Infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.Customer.Aplication.CustomerAdapterOut;

@Service
public class CustomerPortMysql implements CustomerAdapterOut {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }
}
