package edu.uptc.swii.retofinalquery.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/getcustomerbyid")
    public Customer getCustomerByDocument(@RequestBody Customer customer) {
        return customerService.getCustomerByDocument(customer.getDocument());
    }
    

}
