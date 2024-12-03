package edu.uptc.swii.retofinalquery.Customer.Infrastructure;

import edu.uptc.swii.retofinalquery.Customer.Domain.Customer;

public interface CustomerAdapter {
    void saveCustomer(CustomerEntity customer);
    void updateCustomer(CustomerEntity customer);
    Customer getCustomerByDocument(String document);
}
