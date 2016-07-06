package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ekaterina on 18.04.2016.
 */
@Controller
public class SingleController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/single", method = RequestMethod.GET)
    public String single(@RequestParam String productname, ModelMap model){
        model.put("p", productService.getOne(productname));
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.toString().equals("anonymousUser")){
            user = user.toString();
        }
        else {
            Users currentUser = (Users) user;
            user = currentUser.getLogin();
        }
        model.put("user", user);
        return "single";
    }

}
