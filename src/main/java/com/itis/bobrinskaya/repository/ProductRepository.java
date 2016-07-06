package com.itis.bobrinskaya.repository;


import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Ekaterina on 10.04.2016.
 */

public  interface ProductRepository extends JpaRepository<Product, Long> {


     Product findByName(String name);
     List<Product> findByType(ProductTypeEnum type);
     @Query("select p from Product p order by p.id desc")
     List<Product> findOrderById();
     @Query("select p from Product p order by p.price desc")
     List<Product> findOrderByPrice();




}
