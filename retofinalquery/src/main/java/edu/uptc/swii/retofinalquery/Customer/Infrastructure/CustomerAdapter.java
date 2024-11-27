package edu.uptc.swii.retofinalquery.Customer.Infrastructure;

public interface CustomerAdapter {
    void saveCustomer(CustomerEntity customer);
    void updateCustomer(CustomerEntity customer);
    CustomerEntity getCustomerByDocument(String document);
}
