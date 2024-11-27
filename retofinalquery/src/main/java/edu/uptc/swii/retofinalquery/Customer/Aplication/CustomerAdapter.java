package edu.uptc.swii.retofinalquery.Customer.Aplication;

import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;

public interface CustomerAdapter {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
