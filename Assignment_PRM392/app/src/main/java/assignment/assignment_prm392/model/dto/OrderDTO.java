package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "`order`", schema = "Agricultural")
public class OrderDTO {
    private Long id;

    private assignment.assignment_prm392.model.dto.CustomerDTO customer;

    private assignment.assignment_prm392.model.dto.CartDTO cart;

    private assignment.assignment_prm392.model.dto.ProductDTO product;

    private assignment.assignment_prm392.model.dto.StatusDTO status;

    private Integer amount;

    private Double totalPrice;

    private String orderAddress;

    private Instant createdDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    public assignment.assignment_prm392.model.dto.CustomerDTO getCustomer() {
        return customer;
    }

    public OrderDTO setCustomer(assignment.assignment_prm392.model.dto.CustomerDTO customer) {
        this.customer = customer;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    public assignment.assignment_prm392.model.dto.CartDTO getCart() {
        return cart;
    }

    public OrderDTO setCart(assignment.assignment_prm392.model.dto.CartDTO cart) {
        this.cart = cart;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public assignment.assignment_prm392.model.dto.ProductDTO getProduct() {
        return product;
    }

    public OrderDTO setProduct(assignment.assignment_prm392.model.dto.ProductDTO product) {
        this.product = product;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    public assignment.assignment_prm392.model.dto.StatusDTO getStatus() {
        return status;
    }

    public OrderDTO setStatus(assignment.assignment_prm392.model.dto.StatusDTO status) {
        this.status = status;
        return this;
    }

    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public OrderDTO setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    @Column(name = "total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public OrderDTO setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Column(name = "order_address", length = 200)
    public String getOrderAddress() {
        return orderAddress;
    }

    public OrderDTO setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
        return this;
    }

    @Column(name = "created_date")
    public Instant getCreatedDate() {
        return createdDate;
    }

    public OrderDTO setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

}