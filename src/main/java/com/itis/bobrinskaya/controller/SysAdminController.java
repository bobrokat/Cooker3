package com.itis.bobrinskaya.controller;

import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.model.enums.RoleEnum;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ekaterina on 13.05.2016.
 */
@Controller
@RequestMapping(value = "/sysadmin")
public class SysAdminController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getSysadmin(){
        return "/sysadmin";
    }

    @RequestMapping(value ="/addNewAdmin", method = RequestMethod.POST)
    public String addNewAdmin(@RequestParam String login, @RequestParam String password, @RequestParam String role, @RequestParam String phone){
        RoleEnum roleEnum = null;
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        user.setPhone(phone);
        switch (role){
            case "ROLE_COOK_ADMIN": roleEnum = RoleEnum.ROLE_COOK_ADMIN;
                break;
            case "ROLE_CONTENT_ADMIN": roleEnum = RoleEnum.ROLE_CONTENT_ADMIN;
                break;
        }
        user.setRole(roleEnum);
        userService.createUser(user);
        return "redirect:/sysadmin";
    }
}
