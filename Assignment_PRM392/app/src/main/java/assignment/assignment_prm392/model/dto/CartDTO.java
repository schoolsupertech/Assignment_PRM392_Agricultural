package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "cart", schema = "Agricultural")
public class CartDTO {
    private Long id;

    private assignment.assignment_prm392.model.dto.CustomerDTO customer;

    private Integer totalProduct;

    private Double totalPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public CartDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    public assignment.assignment_prm392.model.dto.CustomerDTO getCustomer() {
        return customer;
    }

    public CartDTO setCustomer(assignment.assignment_prm392.model.dto.CustomerDTO customer) {
        this.customer = customer;
        return this;
    }

    @Column(name = "total_product")
    public Integer getTotalProduct() {
        return totalProduct;
    }

    public CartDTO setTotalProduct(Integer totalProduct) {
        this.totalProduct = totalProduct;
        return this;
    }

    @Column(name = "total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public CartDTO setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

}