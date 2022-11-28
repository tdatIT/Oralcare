package com.oralcare.webapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Product> productsByCategoryId;

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
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(name, category.name) && Objects.equals(description, category.description) && Objects.equals(image, category.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, description, image);
    }

    public Collection<Product> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<Product> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
