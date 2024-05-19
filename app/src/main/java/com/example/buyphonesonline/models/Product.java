package com.example.buyphonesonline.models;

public class Product {
    private int id;
   private String image;
    private String name;
    private double price;
    private int quantity;
    private int categoryId;
    private int quantitySold;
    public Product(String image, String name, double price, int quantity, int categoryId) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product(int id, String image, String name, double price, int quantity, int categoryId, int quantitySold) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.quantitySold = quantitySold;
    }

    public Product(String image, String name, double price, int quantity, int categoryId, int quantitySold) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.quantitySold = quantitySold;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int quantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
}
