package com.mastercrafters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Gustavo on 09/06/2016.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/register")
    public String register() {
        return "register-account";
    }

    @RequestMapping("/404")
    public String pageError() {
        return "404";
    }

}
