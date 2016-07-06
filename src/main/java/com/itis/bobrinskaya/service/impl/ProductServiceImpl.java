package com.itis.bobrinskaya.service.impl;

import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Slider;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import com.itis.bobrinskaya.repository.ProductRepository;
import com.itis.bobrinskaya.repository.SliderRepository;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina on 10.04.2016.
 */
@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
     public ProductRepository productRepository;

    @Autowired
     public SliderRepository sliderRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void updateslider(String prod1, String prod2, String prod3) {
        sliderRepository.deleteAll();
        List<String> list = new ArrayList<>();
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        for (String prod : list) {
            Slider element = new Slider();
            element.setProduct(productRepository.findByName(prod));
            sliderRepository.save(element);
        }


    }

    @Override
    public List<Product> getSlider() {
        List<Slider> list = sliderRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (Slider s : list) {
            products.add(s.getProduct());
        }
        return products;
    }


    @Override
    public List<Product> getMealsOfDay() {
        List<Product> allproducts = productRepository.findOrderById();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(allproducts.get(i));
        }

        return products;
    }


    @Override
    public List<Product> getFeaturedMeals() {
        List<Product> list = productRepository.findOrderByPrice();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            products.add(list.get(i));
        }
        return products;
    }


    @Override
    public List<Product> sendToListing(ProductTypeEnum type) {
        List<Product> products = productRepository.findByType(type);
        return products;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    @Override
    public void deleteProd(Product product) {
        productRepository.delete(product);
    }
}




