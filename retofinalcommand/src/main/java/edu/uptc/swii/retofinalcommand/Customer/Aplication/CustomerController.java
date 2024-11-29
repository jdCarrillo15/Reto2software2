package edu.uptc.swii.retofinalcommand.Customer.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.uptc.swii.retofinalcommand.Customer.Domain.Customer;
import edu.uptc.swii.retofinalcommand.Customer.Infrastructure.CustomerEntity;
import edu.uptc.swii.retofinalcommand.utils.JsonUtils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private CustomerPortJson customerPort;
    private JsonUtils jsonUtils;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.jsonUtils = new JsonUtils();
    }

    @PostMapping("/addcustomer")
    public String sendMessageAddCustomer(@RequestBody Customer customer) {
        CustomerEntity CustomerEntity = new CustomerEntity(customer.getDocument(), customer.getFirstname(),
                customer.getLastname(),
                jsonUtils.toJson(customer.getAddress()), customer.getPhone(), customer.getEmail());
        customerService.addCustomer(CustomerEntity);
        return customer.toString();
    }

}
