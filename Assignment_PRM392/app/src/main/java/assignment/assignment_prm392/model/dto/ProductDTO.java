package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "product", schema = "Agricultural")
public class ProductDTO {
    private Long id;

    private String name;

    private String description;

    private Integer number;

    private Double price;

    private byte[] img;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public ProductDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", length = 200)
    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public ProductDTO setNumber(Integer number) {
        this.number = number;
        return this;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public ProductDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Column(name = "img")
    public byte[] getImg() {
        return img;
    }

    public ProductDTO setImg(byte[] img) {
        this.img = img;
        return this;
    }

}