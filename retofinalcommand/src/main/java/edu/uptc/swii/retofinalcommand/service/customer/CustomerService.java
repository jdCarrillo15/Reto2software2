package edu.uptc.swii.retofinalcommand.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.Events.CustomerEventProducer;
import edu.uptc.swii.retofinalcommand.domain.customer.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerPort customerAdapter;
    private CustomerEventProducer customerEventProducer;
    private final String CREATE_CUSTOMER_TOPIC = "create_customer_topic";

    public CustomerService(CustomerAdapterMysql customerAdapter, CustomerEventProducer customerEventProducer) {
        this.customerAdapter = customerAdapter;
        this.customerEventProducer = customerEventProducer;
    }

    public Customer createCustomer(Customer customer) {
        customerAdapter.saveCustomer(customer);
        customerEventProducer.sendMessage(CREATE_CUSTOMER_TOPIC, customer);
        return customer;
    }

}
