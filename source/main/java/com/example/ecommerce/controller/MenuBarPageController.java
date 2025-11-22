package com.example.ecommerce.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MenuBarPageController {

    @GetMapping("/browse")
    public String mainPage(){

        return "browse";
    }

    @GetMapping("/search")
    public String search(){

        return "search";
    }

    @GetMapping("/account")
    public String account(){

        return "account";
    }
}
