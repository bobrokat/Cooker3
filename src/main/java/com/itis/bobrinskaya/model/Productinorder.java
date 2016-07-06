package com.itis.bobrinskaya.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ekaterina on 29.04.2016.
 */
@Entity
@SequenceGenerator(sequenceName = "productinorder_id_seq", name = "productinorder_gen", allocationSize = 1)
public class Productinorder implements Serializable{
    private int id;
    @JsonManagedReference
    private Orders orderByOrderId;
    @JsonManagedReference
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productinorder_gen")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productinorder that = (Productinorder) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public Orders getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Orders orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "id", nullable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
