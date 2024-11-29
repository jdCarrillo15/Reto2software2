package edu.uptc.swii.retofinalquery.Order.Infrastructure;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "order")
public class OrderEntity {
    @Id
    @JsonProperty("orderid")
    private String orderid;
    @JsonProperty("customerid")
    private String customerid;
    @JsonProperty("status")
    private String status;

    public OrderEntity() {
    }

    public OrderEntity(String orderid, String customerid, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [orderid=" + orderid + ", customerid=" + customerid + ", status=" + status + "]";
    }
}