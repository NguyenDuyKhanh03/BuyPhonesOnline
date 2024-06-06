package com.example.buyphonesonline.models;

import java.util.Date;

public class Order {
    private Long id;
    private String orderDate;
    private Double totalAmount;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String orderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double totalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(Long id, String orderDate, Double totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Order() {
    }
}
