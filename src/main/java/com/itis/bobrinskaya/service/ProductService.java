package com.itis.bobrinskaya.service;


import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;

import java.util.List;

/**
 * Created by Ekaterina on 10.04.2016.
 */
public interface ProductService {

    List<Product> getAll();

    Product getOne(String name);

    void updateslider(String prod1, String prod2, String prod3);
    List<Product> getSlider();

    List<Product> getMealsOfDay();

    List<Product> getFeaturedMeals();

    List<Product> sendToListing(ProductTypeEnum type);

    void createProduct(Product product);

    void deleteProd(Product product);
}
