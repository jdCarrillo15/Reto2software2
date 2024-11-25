package edu.uptc.swii.retofinalcommand.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalcommand.domain.customer.Customer;
import edu.uptc.swii.retofinalcommand.service.customer.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addcustomer")
    public String sendMessageAddCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return customer.toString();
    }

}
