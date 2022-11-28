package com.oralcare.webapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sub_id", nullable = false)
    private int subId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @OneToMany(mappedBy = "subscriptionBySubId")
    private Collection<Order> ordersBySubId;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subId == that.subId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subId, name);
    }

    public Collection<Order> getOrdersBySubId() {
        return ordersBySubId;
    }

    public void setOrdersBySubId(Collection<Order> ordersBySubId) {
        this.ordersBySubId = ordersBySubId;
    }
}
