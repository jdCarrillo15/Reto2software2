package edu.uptc.swii.retofinalcommand.Order.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalcommand.Order.Domain.Order;
import edu.uptc.swii.retofinalcommand.Order.Infrastructure.OrderEntity;
import edu.uptc.swii.retofinalcommand.utils.JsonUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private JsonUtils jsonUtils;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.jsonUtils = new JsonUtils();
    }

    @PostMapping("/createorder")
    public String sendMessageCreateOrder(@RequestBody Order order) {
        OrderEntity orderEntity = new OrderEntity(order.getOrderid(), order.getCustomerid(), jsonUtils.toJson(order.getStatus()));
        orderService.createOrder(orderEntity);
        return orderEntity.toString();
    }

    @PostMapping("/updateorder")
    public String sendMessageUpdate(@RequestBody Order order) {
        OrderEntity orderEntity = new OrderEntity(order.getOrderid(), order.getCustomerid(), jsonUtils.toJson(order.getStatus()));
        orderService.updateOrder(orderEntity);
        return orderEntity.toString();    
    }
}
