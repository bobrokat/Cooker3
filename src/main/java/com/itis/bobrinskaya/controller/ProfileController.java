package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Ekaterina on 27.04.2016.
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "")
    public String moderDefault(RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();

        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        redirectAttributes.addAttribute("login", user.getLogin());
        return "redirect:/profile/{login}";
    }
    @RequestMapping(value = "/{login}",method = RequestMethod.GET)
    public String getProfile(ModelMap modelMap, @PathVariable String login) {
        modelMap.addAttribute("user", userService.getOneByLogin(login));

        return "profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam String login, @RequestParam String phone, @RequestParam String password, @RequestParam String repassword, RedirectAttributes redirectAttributes){
        HttpSession session = request.getSession();
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String newlogin = user.getLogin();
        if (!login.equals("")){
            user.setLogin(login);
            newlogin = login;
        }
        if (!phone.equals("")){
            user.setPhone(phone);
        }
        if ((!password.equals("")) && (password.equals(repassword))){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password));
        }
        userService.createUser(user);
        redirectAttributes.addAttribute("login", newlogin);
        return "redirect:/profile/{login}";

    }
}
