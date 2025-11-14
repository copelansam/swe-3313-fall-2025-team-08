package com.example.ecommerce.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String mainPage(){

        return "home";
    }

    @GetMapping("/search")
    public String search(){

        return "search";
    }

    @GetMapping("account")
    public String account(){

        return "account";
    }
}
