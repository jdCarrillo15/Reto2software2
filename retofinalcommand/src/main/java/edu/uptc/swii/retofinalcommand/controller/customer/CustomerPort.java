package edu.uptc.swii.retofinalcommand.controller.customer;

import edu.uptc.swii.retofinalcommand.domain.customer.Customer;

public interface CustomerPort {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
