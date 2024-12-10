package main.java.com.ecommerce.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int sellerId;

    // Constructor, Getters, and Setters
    public Product(int id, String name, String description, double price, int quantity, int sellerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSellerId() {
        return sellerId;
    }
}


