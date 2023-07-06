package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "payment", schema = "Agricultural")
public class PaymentDTO {
    private Long id;

    private assignment.assignment_prm392.model.dto.OrderDTO order;

    private assignment.assignment_prm392.model.dto.StatusDTO status;

    private Double totalPrice;

    private Instant createdDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public PaymentDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    public assignment.assignment_prm392.model.dto.OrderDTO getOrder() {
        return order;
    }

    public PaymentDTO setOrder(assignment.assignment_prm392.model.dto.OrderDTO order) {
        this.order = order;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    public assignment.assignment_prm392.model.dto.StatusDTO getStatus() {
        return status;
    }

    public PaymentDTO setStatus(assignment.assignment_prm392.model.dto.StatusDTO status) {
        this.status = status;
        return this;
    }

    @Column(name = "total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public PaymentDTO setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Column(name = "created_date")
    public Instant getCreatedDate() {
        return createdDate;
    }

    public PaymentDTO setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

}