package com.itis.bobrinskaya.model;

import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ekaterina on 17.04.2016.
 */
@Entity
@SequenceGenerator(sequenceName = "product_id_seq", name = "prod_gen", allocationSize = 1)
public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
   // private String type;
    private String description;
    private String photo;
    private ProductTypeEnum type;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_gen")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 17)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = false, insertable = true, updatable = true, length = 150)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (photo != null ? !photo.equals(product.photo) : product.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    public StringProperty idProperty() {
        String s = String.valueOf(this.getId());
        StringProperty idprop = new SimpleStringProperty(s);
        return  idprop;
    }

    public StringProperty nameProperty() {
        StringProperty nameprop = new SimpleStringProperty(this.getName());
        return nameprop;
    }
}
