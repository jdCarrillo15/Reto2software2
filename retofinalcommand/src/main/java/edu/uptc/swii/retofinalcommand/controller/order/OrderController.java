package edu.uptc.swii.retofinalcommand.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalcommand.domain.order.Order;
import edu.uptc.swii.retofinalcommand.service.order.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createorder")
    public String sendMessageCreateOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return order.toString();
    }

    @PostMapping("/updateorder")
    public String sendMessageUpdate(@RequestBody Order order) {
        orderService.updateOrder(order);
        return order.toString();    
    }
}
