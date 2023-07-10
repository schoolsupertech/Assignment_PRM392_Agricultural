package com.example.lab10.Model;

public class Product {
    private double price;
    private String name;
    private int number;
    private String description;

    public Product(double price, String name, int number, String description) {
        this.price = price;
        this.name = name;
        this.number = number;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
