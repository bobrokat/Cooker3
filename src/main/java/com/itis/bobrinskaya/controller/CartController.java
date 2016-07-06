package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Orders;
import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Productinorder;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.OrderService;
import com.itis.bobrinskaya.service.ProductService;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ekaterina on 27.04.2016.
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @RequestMapping (method = RequestMethod.GET)
    public String getCard(ModelMap model){
       Object user =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Product> productsFeatured = productService.getFeaturedMeals();
        model.put("productsFeatured", productsFeatured);
        if (user.toString().equals("anonymousUser")){
            return "redirect:/index";
        }
        else {
            HttpSession session = request.getSession();
            List<Product> productsInCart = (List<Product>) session.getAttribute("productsInCart");
            model.put("productsInCart", productsInCart);
            double sum = 0;
            for(Product product: productsInCart){
                sum += product.getPrice();
            }
            model.put("summa", sum);
            session.setAttribute("price", sum);
            return "cart";
        }
    }
    @RequestMapping (method = RequestMethod.POST)
    public String addToCart(HttpServletRequest request, @RequestParam String productname){
        HttpSession session = request.getSession();
        List<Product> productsInCart = (List<Product>) session.getAttribute("productsInCart");
        productsInCart.add(productService.getOne(productname));
        session.setAttribute("productsInCart", productsInCart);

        return "redirect:/cart";
    }

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    public String getOrder(@RequestParam String address, @RequestParam String note, @RequestParam String payment_option, RedirectAttributes redirectAttributes){
       Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpSession session= request.getSession();
        redirectAttributes.addAttribute("login", user.getLogin());
        Orders order = new Orders();
        order.setAddress(address);
        order.setUser(user);
        order.setNote(note);
        double price = (double) session.getAttribute("price");
        if (payment_option.equals("bonus")) {
            if (user.getBonus() >= 0) {
                if(user.getBonus() >= price){
                    order.setPrice((double) 0);
                    user.setBonus((int) (user.getBonus() - price));
                    userService.createUser(user);
                }
                else {
                    order.setPrice(price - user.getBonus());
                    user.setBonus(0);
                    userService.createUser(user);
                }


            }
            else {
                return "redirect:/cart";
            }

        }
        else {
            order.setPrice(price);
            if(price > 1000){
                int bonus = user.getBonus();
                bonus += 100;
                user.setBonus(bonus);
                userService.createUser(user);

            }
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        order.setDate(format.format(new Date()));
        orderService.createNewOrder(order);

        List<Product> products = (List<Product>) session.getAttribute("productsInCart");
        int id = orderService.getUsersLastOrder(user.getId());
        Orders currentorder = orderService.getOne(id);
        for(Product product : products) {
            Productinorder productinorder = new Productinorder();
            productinorder.setProduct(product);
            productinorder.setOrderByOrderId(currentorder);
            orderService.addproducts(productinorder);

        }
        clearCart(request);
        return "redirect:/profile/{login}";
    }

    @RequestMapping (value = "/clear")
    public String clearCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("productsInCart");
        products.clear();
        session.setAttribute("productsInCart", products);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/removeProduct")
    public String removeProduct(@RequestParam String prodremove ){
        HttpSession session = request.getSession();
        List<Product> productsInCart = (List<Product>) session.getAttribute("productsInCart");
        productsInCart.remove(productService.getOne(prodremove));
        session.setAttribute("productsInCart", productsInCart);
        return "redirect:/cart";

    }

}
