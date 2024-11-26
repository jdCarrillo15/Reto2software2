package edu.uptc.swii.retofinalquery.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;
import edu.uptc.swii.retofinalquery.service.customer.CustomerService;
import edu.uptc.swii.retofinalquery.utils.JsonUtils;

@Service
public class CustomerEventConsumer {
    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "add-customer-topic", groupId = "customer-group")
    public void addCustomerConsume(String message) {
        message = message.replace("\\", "");
        message = message.substring(1, message.length() - 1);
        System.out.println("Add Customer - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        Customer savedCustomer = jsonUtils.fromJson(message, Customer.class);
        customerService.createCustomer(savedCustomer);
    }

}
