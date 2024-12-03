package edu.uptc.swii.retofinalcommand.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.Customer.Infrastructure.CustomerPortMysql;
import edu.uptc.swii.retofinalcommand.Customer.Infrastructure.CustomerEntity;

@Service
public class CustomerService {
    @Autowired
    private CustomerAdapterOut customerAdapter;
    private CustomerEventProducer customerEventProducer;
    private final String CREATE_CUSTOMER_TOPIC = "create-customer-topic";

    public CustomerService(CustomerPortMysql customerAdapter, CustomerEventProducer customerEventProducer) {
        this.customerAdapter = customerAdapter;
        this.customerEventProducer = customerEventProducer;
    }

    public CustomerEntity addCustomer(CustomerEntity customer) {
        CustomerEntity customerSave = customerAdapter.saveCustomer(customer);
        customerEventProducer.sendMessage(CREATE_CUSTOMER_TOPIC, customer);
        return customerSave;
    }

}
