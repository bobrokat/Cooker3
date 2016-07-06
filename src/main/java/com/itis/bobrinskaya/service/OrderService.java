package com.itis.bobrinskaya.service;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;

import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */
public interface OrderService {
    List<Orders> getAll();
    List<Orders> getNotReady();
    List<Orders> getReady();
    Orders createNewOrder(Orders order);
    Productinorder addproducts(Productinorder productinorder);

    int getUsersLastOrder(int id);
    Orders getOne(int id);
}
