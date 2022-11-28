package com.oralcare.webapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<OrderItems> orderItemsByProductId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false,
            updatable = false,insertable = false)
    private Category categoryByCategoryId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && categoryId == product.categoryId && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId, name, description, price, image);
    }

    public Collection<OrderItems> getOrderItemsByProductId() {
        return orderItemsByProductId;
    }

    public void setOrderItemsByProductId(Collection<OrderItems> orderItemsByProductId) {
        this.orderItemsByProductId = orderItemsByProductId;
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
