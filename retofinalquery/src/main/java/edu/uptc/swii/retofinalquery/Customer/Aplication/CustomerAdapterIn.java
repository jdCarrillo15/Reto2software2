package edu.uptc.swii.retofinalquery.Customer.Aplication;

import edu.uptc.swii.retofinalquery.Customer.Infrastructure.CustomerEntity;

public interface CustomerAdapterIn {
    void saveCustomer(CustomerEntity customer);
    void updateCustomer(CustomerEntity customer);
}
