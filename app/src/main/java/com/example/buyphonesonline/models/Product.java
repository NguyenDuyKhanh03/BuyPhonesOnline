package com.example.buyphonesonline.models;

public class Product {
    private Long id;
   private String image;
    private String name;
    private double price;
    private String description;
    private int quantity;
    private Long categoryId;

    public Product(String image, String name, double price, String description, int quantity, Long categoryId) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Product(Long id, String image, String name, double price, int quantity, Long categoryId) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }


    public Product(Long id, String image, String name, double price, String description, int quantity, Long categoryId) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    // Getters and Setters


    public Long id() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
