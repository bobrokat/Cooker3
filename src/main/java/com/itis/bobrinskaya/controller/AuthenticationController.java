package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.form.RegistrationForm;
import com.itis.bobrinskaya.model.Product;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina on 26.04.2016.
 */
@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "index";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
            if (request.isUserInRole("ROLE_CONTENT_ADMIN")) {
                return "redirect:/contentadmin";
            } else if (request.isUserInRole("ROLE_COOK_ADMIN")) {
                return "redirect:/cookadmin";
            }
            else if(request.isUserInRole("ROLE_SYSTEM_ADMIN")){
                return "redirect:/sysadmin";

            } else if (request.isUserInRole("ROLE_USER")) {
                List<Product> productsInCart = new ArrayList<>();
                session.setAttribute("productsInCart", productsInCart);
                return "redirect:/profile";
            } else {
                return "redirect:/index";
            }

    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userform") @Valid RegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/index";
        }
        if (userService.getOneByLogin(form.getLogin()) != null) {
            return "redirect:/index";
        }
            //check(form.getLogin());

        if (!form.getPassword().equals(form.getRepassword())) {
            System.out.println("passwords doesn't match");
            return "redirect:/index";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String login = form.getLogin();
        String phone = form.getPhone();
        String password = form.getPassword();
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(encoder.encode(password));
        user.setPhone(phone);
        user.setRole(form.getRole());
        user.setBonus(0);
        userService.createUser(user);
        return "redirect:/default";
    }

    @RequestMapping(value = "/index/checklogin", method = RequestMethod.POST)
    public @ResponseBody String check(@RequestParam String loginreg) {
        if (userService.getOneByLogin(loginreg) != null) {
            return "on";
        } else {
            return "off";
        }

    }

    @RequestMapping(value = "/index/checkphone", method = RequestMethod.POST)
    public @ResponseBody String checkphone(@RequestParam String phone) {
        if (userService.getOneByPhone(phone) != null) {
            return "on";
        } else {
            return "off";
        }

    }


}
