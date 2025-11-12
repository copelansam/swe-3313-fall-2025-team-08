package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateAccountController {

    @GetMapping("/sign-up")
    public String signIn(){

        return "sign-up";
    }
}
