package assignment.assignment_prm392.model.dto;

public class CartDTO {
    private String id;

    private int totalProduct;

    private Double totalPrice;

    public CartDTO() {
    }

    public CartDTO(String id, int totalProduct, Double totalPrice) {
        this.id = id;
        this.totalProduct = totalProduct;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public CartDTO setId(String id) {
        this.id = id;
        return this;
    }

    public int getTotalProduct() {
        return totalProduct;
    }

    public CartDTO setTotalProduct(int totalProduct) {
        this.totalProduct = totalProduct;
        return this;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public CartDTO setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

}