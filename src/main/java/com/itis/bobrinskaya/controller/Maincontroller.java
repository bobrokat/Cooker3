package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.form.RegistrationForm;
import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Ekaterina on 12.04.2016.
 */

@Controller
public class Maincontroller {
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String hiPage(ModelMap model) {
        List<Product> productsSlider = productService.getSlider();
        List<Product> productOfDay = productService.getMealsOfDay();
        List<Product> productsFeatured = productService.getFeaturedMeals();
        model.put("productsSlider", productsSlider);
        model.put("productsOfDay", productOfDay);
        model.put("productsFeatured", productsFeatured);
        model.addAttribute("moder_form", new RegistrationForm());
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.toString().equals("anonymousUser")){
            user = user.toString();
        }
        else {
            Users currentUser = (Users) user;
            user = currentUser.getLogin();
        }
        model.put("user", user);
        return "index";
    }

}
