package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// Passes the first screen that the user will encounter (login screen)
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "index";
    }
}
