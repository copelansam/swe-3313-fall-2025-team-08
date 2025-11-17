package com.example.ecommerce.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPagesController {

    @GetMapping("/cart")
    public String cart(){

        return "cart";
    }

    @GetMapping("/payment")
    public String payment(){

        return "payment";
    }

    @GetMapping("/confirm")
    public String confirm(){

        return "confirm";
    }

    @GetMapping("/receipt")
    public String receipt(){
        return "receipt";
    }
}
