package com.itis.bobrinskaya.service.impl;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Productinorder;
import com.itis.bobrinskaya.repository.OrderRepository;
import com.itis.bobrinskaya.repository.ProductInOrderRepository;
import com.itis.bobrinskaya.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ekaterina on 29.04.2016.
 */
@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
     public OrderRepository orderRepository;
    @Autowired
    public ProductInOrderRepository productInOrderRepository;

    @Override
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Orders> getNotReady() {
        return orderRepository.findNotReady();
    }

    @Override
    public List<Orders> getReady() {
        return orderRepository.findReady();
    }

    @Override
    public Orders createNewOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Productinorder addproducts(Productinorder productinorder) {
        return productInOrderRepository.save(productinorder);
    }

    @Override
    public int getUsersLastOrder(int id) {
        return orderRepository.findUsersLastOrder(id);
    }

    @Override
    public Orders getOne(int id) {
        return orderRepository.findOne(id);
    }
}
