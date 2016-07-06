package com.itis.bobrinskaya.api.controller;

import com.itis.bobrinskaya.api.service.AuthService;
import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.enums.ProductTypeEnum;
import com.itis.bobrinskaya.repository.ProductRepository;
import com.itis.bobrinskaya.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ekaterina on 27.05.2016.
 */

@RestController
@RequestMapping(value = "api")
public class FXController {
    @Autowired
    AuthService authService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> login(String login, String password) {
        if (authService.authAdmin(password, login)) {
            return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/getProds", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Product[]> getProds() {
        List<Product> products = productRepository.findAll();
        Product[] products1 = new Product[products.size()];
        for(int i = 0; i < products.size(); i ++){
            products1[i] = products.get(i);
        }
        ResponseEntity<Product[]> responseEntity = new ResponseEntity<Product[]>(products1, HttpStatus.OK);
        return  responseEntity;
    }



    @RequestMapping(value = "/getProd", method = RequestMethod.POST)
     @ResponseBody
     public ResponseEntity<Product> getProd(String name) {
        Product product = productRepository.findByName(name);
        ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);
        System.out.println(responseEntity.getBody().getName());
        return responseEntity;
    }

    @RequestMapping(value = "/deleteProd", method = RequestMethod.POST)
    @ResponseBody
    public void deleteProd(@RequestParam("name") String name) {
        if(productService.getOne(name) != null) {
           productService.deleteProd(productService.getOne(name));
        }
    }


    @RequestMapping(value = "/addProd", method = RequestMethod.POST)
    @ResponseBody
    public void  addProd(
                                             @RequestParam ("name") String name,
                                             @RequestParam ("price") String price,
                                             @RequestParam ("description") String description,
                                             @RequestParam ("type")String type
    ) {
        System.out.println("from params " + name);
        if(productService.getOne(name) == null){
            Product product = new Product();
            product.setName(name);
            product.setPrice(Double.parseDouble(price));
            product.setDescription(description);
            product.setPhoto("images/meal-1.png");
            ProductTypeEnum productTypeEnum = null;
            switch (type){
                case "PIZZA": productTypeEnum = ProductTypeEnum.PIZZA;
                    break;
                case "ROLL": productTypeEnum = ProductTypeEnum.ROLL;
                    break;
                case "WOK": productTypeEnum = ProductTypeEnum.WOK;
                    break;
                case "DESERT": productTypeEnum = ProductTypeEnum.DESERT;
                    break;
                case "DRINK": productTypeEnum = ProductTypeEnum.DRINK;
                    break;
                case "ANOTHER": productTypeEnum = ProductTypeEnum.ANOTHER;
                    break;
                case "KOMBO": productTypeEnum = ProductTypeEnum.KOMBO;
            }
            product.setType(productTypeEnum);
            System.out.println("correct");
            productService.createProduct(product);
        }

    }
}
