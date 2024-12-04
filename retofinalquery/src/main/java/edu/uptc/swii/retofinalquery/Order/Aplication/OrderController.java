package edu.uptc.swii.retofinalquery.Order.Aplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalquery.Order.Domain.Order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/searchorderbycustomerid/{customerid}")
    public List<Order> sendMessageSearchOrderByCustomerID(@PathVariable String customerid) {
        return orderService.searchOrderByCustomerID(customerid);
    }

}
