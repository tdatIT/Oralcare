package com.oralcare.webapp.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "contact")
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contact_id", nullable = false)
    private int contactId;

    @Basic
    @Column(name = "content", nullable = false)
    private String content;
    @Basic
    @Column(name = "rateting", nullable = true)
    private Integer rateting;
    @Basic
    @Column(name = "email", nullable = true)
    private String email;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRateting() {
        return rateting;
    }

    public void setRateting(Integer rateting) {
        this.rateting = rateting;
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
        Contact contact = (Contact) o;
        return contactId == contact.contactId && Objects.equals(content, contact.content) && Objects.equals(rateting, contact.rateting) && Objects.equals(createDate, contact.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, content, rateting, createDate);
    }


}
