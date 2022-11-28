package com.oralcare.webapp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "order")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "sub_id", nullable = true)
    private Integer subId;
    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    private double amount;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,
            updatable = false, insertable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id",
            updatable = false, insertable = false)
    private Subscription subscriptionBySubId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderItems> orderItemsByOrderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && userId == order.userId && Double.compare(order.amount, amount) == 0 && Objects.equals(subId, order.subId) && Objects.equals(address, order.address) && Objects.equals(createDate, order.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, subId, amount, address, createDate);
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Subscription getSubscriptionBySubId() {
        return subscriptionBySubId;
    }

    public void setSubscriptionBySubId(Subscription subscriptionBySubId) {
        this.subscriptionBySubId = subscriptionBySubId;
    }

    public Collection<OrderItems> getOrderItemsByOrderId() {
        return orderItemsByOrderId;
    }

    public void setOrderItemsByOrderId(Collection<OrderItems> orderItemsByOrderId) {
        this.orderItemsByOrderId = orderItemsByOrderId;
    }
}
