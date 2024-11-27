package edu.uptc.swii.retofinalcommand.Customer.Aplication;

import edu.uptc.swii.retofinalcommand.Customer.Infrastructure.CustomerEntity;

public interface CustomerAdapterOut {
    CustomerEntity saveCustomer(CustomerEntity customer);
    void updateCustomer(CustomerEntity customer);
}
