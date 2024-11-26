package edu.uptc.swii.retofinalquery.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerPort customerAdapter;

    public CustomerService(CustomerAdapterMongo customerAdapter) {
        this.customerAdapter = customerAdapter;
    }

    public Customer createCustomer(Customer customer) {
        customerAdapter.saveCustomer(customer);
        return customer;
    }

    public Customer getCustomerByDocument(String document) {
        return customerAdapter.getCustomerByDocument(document);
    }

}
