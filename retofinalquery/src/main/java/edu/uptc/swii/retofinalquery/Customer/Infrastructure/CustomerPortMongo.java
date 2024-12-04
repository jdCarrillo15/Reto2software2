package edu.uptc.swii.retofinalquery.Customer.Infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.swii.retofinalquery.Customer.Domain.Address;
import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;

@Service
public class CustomerPortMongo implements CustomerAdapter {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerEntity customer) {
        customerRepository.insert(customer);
    }

    @Override
    public void updateCustomer(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByDocument(String document) {
        return customEToCustomer(customerRepository.findById(document).get());
    }

    private Customer customEToCustomer(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setDocument(customerEntity.getDocument());
        customer.setFirstname(customerEntity.getFirstname());
        customer.setLastname(customerEntity.getLastname());
        customer.setPhone(customerEntity.getPhone());
        customer.setEmail(customerEntity.getEmail());
        String[] addrStringChr = customerEntity.getAddress().split("-");
        customer.setAddress(new Address(addrStringChr[0], addrStringChr[1], addrStringChr[2], addrStringChr[3]));
        return customer;
    }
}
