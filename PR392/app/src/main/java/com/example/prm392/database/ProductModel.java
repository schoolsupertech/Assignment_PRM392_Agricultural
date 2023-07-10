package com.example.prm392.database;

public class ProductModel {
    private final int id;
    private final String name;
    private final double price;
    private final int number;
    private final byte[] img;

    public ProductModel(int id, String name, double price, int number, byte[] img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public byte[] getImg() {
        return img;
    }
}
