package edu.uptc.swii.retofinalquery.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalquery.domain.order.Order;
import edu.uptc.swii.retofinalquery.service.order.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/searchorderbycustomerid")
    public String sendMessageSearchOrderByCustomerID(@RequestBody Order order) {
        orderService.searchOrderByCustomerID(order.getCustomerid());
        return order.toString();
        }

}
