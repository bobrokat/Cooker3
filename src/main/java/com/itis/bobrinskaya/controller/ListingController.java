package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Ekaterina on 14.04.2016.
 */

@Controller
public class ListingController {

    @Autowired
    ProductService productService;



@RequestMapping(value = "/listing", method = RequestMethod.GET)
    public String getListing(ModelMap model, @RequestParam ProductTypeEnum type){
    List<Product> products = productService.sendToListing(type);
    List<Product> productsFeatured = productService.getFeaturedMeals();
    model.put("products", products);
    model.put("productsFeatured", productsFeatured);
    Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (user.toString().equals("anonymousUser")){
        user = user.toString();
    }
    else {
        Users currentUser = (Users) user;
        user = currentUser.getLogin();
    }
    model.put("user", user);
    return "listing";
}


}
