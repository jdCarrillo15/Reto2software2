package edu.uptc.swii.retofinalquery.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerEntity;
import edu.uptc.swii.retofinalquery.utils.JsonUtils;

@Service
public class CustomerEventConsumer {
    @Autowired
    private CustomerService customerService;

    @KafkaListener(topics = "create-customer-topic", groupId = "customer-group")
    public void addCustomerConsume(String message) {
        message = message.replace("\\", "");
        message = message.substring(1, message.length() - 1);
        System.out.println("Add Customer - Received Message: " + message);
        JsonUtils jsonUtils = new JsonUtils();
        CustomerEntity savedCustomer = jsonUtils.fromJson(message, CustomerEntity.class);
        customerService.createCustomer(savedCustomer);
    }

}
