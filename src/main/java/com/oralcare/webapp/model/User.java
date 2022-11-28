package com.oralcare.webapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    private String lastname;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "birthday", nullable = false)
    private Date birthday;
    @Basic
    @Column(name = "phone_number", nullable = false, length = 255)
    private String phoneNumber;
    @Basic
    @Column(name = "status_health", nullable = false, length = 255)
    private String statusHealth;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate = new Timestamp(new java.util.Date().getTime());

    @OneToMany(mappedBy = "userByUserId")
    private Collection<Order> ordersByUserId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatusHealth() {
        return statusHealth;
    }

    public void setStatusHealth(String statusHealth) {
        this.statusHealth = statusHealth;
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
        User user = (User) o;
        return userId == user.userId && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(birthday, user.birthday) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(statusHealth, user.statusHealth) && Objects.equals(address, user.address) && Objects.equals(createDate, user.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, birthday, phoneNumber, statusHealth, address, createDate);
    }

    public Collection<Order> getOrdersByUserId() {
        return ordersByUserId;
    }

    public void setOrdersByUserId(Collection<Order> ordersByUserId) {
        this.ordersByUserId = ordersByUserId;
    }
}
