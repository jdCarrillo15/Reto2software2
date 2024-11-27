package edu.uptc.swii.retofinalquery.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerPortMongo;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerAdapter;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerEntity;

@Service
public class CustomerService {
    @Autowired
    private CustomerAdapter customerAdapter;

    public CustomerService(CustomerPortMongo customerAdapter) {
        this.customerAdapter = customerAdapter;
    }

    public CustomerEntity createCustomer(CustomerEntity customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer.getDocument(), customer.getFirstname(), customer.getLastname(), customer.getEmail(), customer.getPhone());
        customerAdapter.saveCustomer(customerEntity);
        return customer;
    }

    public Customer getCustomerByDocument(String document) {
        CustomerEntity customerEntity = customerAdapter.getCustomerByDocument(document);
        if (customerEntity != null) {
            Customer customer = new Customer(customerEntity.getDocument(), customerEntity.getFirstname(), customerEntity.getLastname(), customerEntity.getEmail(), customerEntity.getPhone(), null);
            customer.setAddressString(customerEntity.getAddress());
            return customer;
        }
        return null;
    }

}
