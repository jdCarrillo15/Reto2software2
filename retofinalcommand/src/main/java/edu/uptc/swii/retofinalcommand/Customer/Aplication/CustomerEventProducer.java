package edu.uptc.swii.retofinalcommand.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.Customer.Infrastructure.CustomerEntity;
import edu.uptc.swii.retofinalcommand.utils.JsonUtils;

@Service
public class CustomerEventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String type;
    private CustomerEntity customer;

    public String getType() {
        return type;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void sendMessage (String topic, CustomerEntity customer) {
        String message = new String();
        JsonUtils jsonUtils = new JsonUtils();
        message = jsonUtils.toJson(customer);
        System.out.println("CustomerEventProducer sendMessage: " + message);
        kafkaTemplate.send(topic, message);
    }

}