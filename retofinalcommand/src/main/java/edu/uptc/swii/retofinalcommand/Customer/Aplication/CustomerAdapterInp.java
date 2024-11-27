package edu.uptc.swii.retofinalcommand.Customer.Aplication;

import edu.uptc.swii.retofinalcommand.Customer.Domain.Customer;

public interface CustomerAdapterInp {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
