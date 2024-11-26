package edu.uptc.swii.retofinalquery.service.customer;

import edu.uptc.swii.retofinalquery.domain.customer.Customer;

public interface CustomerPort {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerByDocument(String document);
}
