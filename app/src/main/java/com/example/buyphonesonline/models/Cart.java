package com.example.buyphonesonline.models;

public class Cart {
    private int id;
    private double totalPrice;
    private String username;

    public Cart(int id, double totalPrice, String username) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.username = username;
    }

    public Cart() {
    }

    public Cart(double totalPrice, String username) {
        this.totalPrice = totalPrice;
        this.username = username;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double totalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
