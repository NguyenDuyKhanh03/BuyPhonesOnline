package com.example.buyphonesonline.dtos;

public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private double price;
    private int quantity;

    public ProductDto(Long id, String name, String image, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDto() {
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String image() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int quantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity() {
        this.quantity+=1;
    }

    public void decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity-=1;
        }
    }

    public ProductDto(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
