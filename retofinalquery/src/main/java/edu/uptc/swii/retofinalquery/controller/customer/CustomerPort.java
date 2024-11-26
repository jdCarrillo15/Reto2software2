package edu.uptc.swii.retofinalquery.controller.customer;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;

public interface CustomerPort {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
