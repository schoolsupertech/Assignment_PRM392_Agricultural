package assignment.assignment_prm392.model.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private String id;

    private String name;

    private String description;

    private int number;

    private Double price;

    private byte[] img;

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String description, int number, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.number = number;
        this.price = price;
    }

    public ProductDTO(String id, String name, String description, int number, Double price, byte[] img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.number = number;
        this.price = price;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public ProductDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImg() {
        return img;
    }

    public ProductDTO setImg(byte[] img) {
        this.img = img;
        return this;
    }

}