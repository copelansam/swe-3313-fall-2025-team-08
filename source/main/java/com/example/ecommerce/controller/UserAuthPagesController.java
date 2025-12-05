package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


// Passes the create account screen to the view
@Controller
public class UserAuthPagesController {

    // Directs the system to display the sign in screen
    @GetMapping("/")
    public String signIn(Model model) {

        return "login";
    }

    // Directs the system to display the create account screen
    @GetMapping("/create-account")
    public String signUp() {

        return "create-account";
    }
}
