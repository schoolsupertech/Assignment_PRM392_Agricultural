package assignment.assignment_prm392.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartProductDTOId implements Serializable {
    private static final long serialVersionUID = 8230557959551269238L;
    private Long cartId;

    private Long productId;

    @Column(name = "cart_id", nullable = false)
    public Long getCartId() {
        return cartId;
    }

    public CartProductDTOId setCartId(Long cartId) {
        this.cartId = cartId;
        return this;
    }

    @Column(name = "product_id", nullable = false)
    public Long getProductId() {
        return productId;
    }

    public CartProductDTOId setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProductDTOId entity = (CartProductDTOId) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.cartId, entity.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, cartId);
    }

}