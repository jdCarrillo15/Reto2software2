package edu.uptc.swii.retofinalcommand.Order.Domain;

public class Order {
    private String orderid;
    private String customerid;
    private Status status;

    public Order() {
    }

    public Order(String orderid, String customerid, Status status) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.status = status;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [orderid=" + orderid + ", customerid=" + customerid + ", status=" + status + "]";
    }
}
