package edu.uptc.swii.retofinalquery.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Customer.Domain.Address;
import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerPortMongo;
import edu.uptc.swii.retofinalquery.utils.JsonUtils;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerAdapter;
import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerEntity;

@Service
public class CustomerService {
    @Autowired
    private CustomerAdapter customerAdapter;
    private JsonUtils jsonUtils;

    public CustomerService(CustomerPortMongo customerAdapter) {
        this.customerAdapter = customerAdapter;
        this.jsonUtils = new JsonUtils();
    }

    public CustomerEntity createCustomer(CustomerEntity customer) {
        customerAdapter.saveCustomer(customer);
        return customer;
    }

    public Customer getCustomerByDocument(String document) {
        CustomerEntity customerEntity = customerAdapter.getCustomerByDocument(document);
        if (customerEntity != null) {
            Customer customer = new Customer(customerEntity.getDocument(), customerEntity.getFirstname(),
                    customerEntity.getLastname(), customerEntity.getEmail(), customerEntity.getPhone(), jsonUtils.fromJson(customerEntity.getAddress(), Address.class));
            return customer;
        }
        return null;
    }

}
