package com.itis.bobrinskaya.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ekaterina on 29.04.2016.
 */
@Entity
@SequenceGenerator(sequenceName = "order_id_seq", name = "order_gen", allocationSize = 1)
public class Orders implements Serializable {
    private int id;
    private String address;
    @JsonManagedReference
    private Users user;
    private boolean status;
    private Double price;
    @JsonBackReference
    private Collection<Productinorder> productinorderList = new ArrayList<>();
    private String note;
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 150)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "orderByOrderId")
    public Collection<Productinorder> getProductinorderList() {
        return productinorderList;
    }


    public void setProductinorderList(Collection<Productinorder> productinorderList) {
        this.productinorderList = productinorderList;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (user != orders.user) return false;
        if (status != orders.status) return false;
        if (address != null ? !address.equals(orders.address) : orders.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + user.hashCode();
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, precision = 17)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 150)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
