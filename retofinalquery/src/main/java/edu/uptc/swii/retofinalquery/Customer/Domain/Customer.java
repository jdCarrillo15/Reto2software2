package edu.uptc.swii.retofinalquery.Customer.Domain;

public class Customer {
    private String document;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;

    public Customer() {
    }

    public Customer(String document, String firstName, String lastName, String email, String phone, Address address) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddressString(String addressString) {
        String[] addressParts = addressString.split("|");
        this.address = new Address();
        this.address.setStreet(addressParts[0]);
        this.address.setNumber(addressParts[1]);
        this.address.setCity(addressParts[2]);
        this.address.setCountry(addressParts[3]);
    }

    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
                + ", address=" + address + "]";
    }
}
