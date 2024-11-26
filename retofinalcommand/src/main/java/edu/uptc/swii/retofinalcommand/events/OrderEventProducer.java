package edu.uptc.swii.retofinalcommand.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalcommand.domain.order.Order;
import edu.uptc.swii.retofinalcommand.utils.JsonUtils;

@Service
public class OrderEventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private String type;
    private Order order;
    
    public String getType() {
        return type;
    }
    public Order getOrder() {
        return order;
    }

    public void sendMessage(String topic, Order order) {
        String message = new String();
        JsonUtils jsonUtils = new JsonUtils();
        message = jsonUtils.toJson(order);
        System.out.println("OrderEventProducer sendMessage: " + message);
        kafkaTemplate.send(topic, order.toString());
    }
}
