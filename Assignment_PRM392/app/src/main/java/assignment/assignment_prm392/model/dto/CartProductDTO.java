package assignment.assignment_prm392.model.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_product", schema = "Agricultural")
public class CartProductDTO {
    private CartProductDTOId id;

    private assignment.assignment_prm392.model.dto.CartDTO cart;

    private assignment.assignment_prm392.model.dto.ProductDTO product;

    @EmbeddedId
    public CartProductDTOId getId() {
        return id;
    }

    public CartProductDTO setId(CartProductDTOId id) {
        this.id = id;
        return this;
    }

    @MapsId("cartId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    public assignment.assignment_prm392.model.dto.CartDTO getCart() {
        return cart;
    }

    public CartProductDTO setCart(assignment.assignment_prm392.model.dto.CartDTO cart) {
        this.cart = cart;
        return this;
    }

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    public assignment.assignment_prm392.model.dto.ProductDTO getProduct() {
        return product;
    }

    public CartProductDTO setProduct(assignment.assignment_prm392.model.dto.ProductDTO product) {
        this.product = product;
        return this;
    }

}