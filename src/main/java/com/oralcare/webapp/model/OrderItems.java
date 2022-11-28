package com.oralcare.webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "oralcare_db", catalog = "")
public class OrderItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "item_id", nullable = false)
    private int itemId;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id",
            nullable = false,updatable = false,insertable = false)
    private Order orderByOrderId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false,
            updatable = false,insertable = false)
    private Product productByProductId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return itemId == that.itemId && orderId == that.orderId && productId == that.productId && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, orderId, productId, quantity);
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
