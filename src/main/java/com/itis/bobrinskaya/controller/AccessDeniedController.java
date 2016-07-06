package com.itis.bobrinskaya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ekaterina on 27.04.2016.
 */
@Controller
public class AccessDeniedController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String acessDenied( ){
        return "403";
    }
}
