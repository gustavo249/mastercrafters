package com.mastercrafters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gustavo on 09/06/2016.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/shoes")
    public String shoes() {
        return "shoes";
    }

    @RequestMapping("/clothes")
    public String clothes() {
        return "clothes";
    }

    @RequestMapping("/technology")
    public String technology() {
        return "technology";
    }

    @RequestMapping("/myaccount")
    public String myaccount() {
        return "myaccount";
    }

    @RequestMapping("/orders")
    public String orders() {
        return "orders";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping
    public String success() {
        return "success";
    }
}
