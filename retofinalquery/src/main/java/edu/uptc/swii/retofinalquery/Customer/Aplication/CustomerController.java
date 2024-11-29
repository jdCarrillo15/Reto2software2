package edu.uptc.swii.retofinalquery.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getcustomerbyid/{document}")
    public Customer getCustomerByDocument(@PathVariable() String document) {
        return customerService.getCustomerByDocument(document);
    }

}
