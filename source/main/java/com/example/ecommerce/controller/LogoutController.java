package com.example.ecommerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @GetMapping("/account")
    public String account(){

        return "account";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // log the user out by removing all of their attributes and redirect to log in screen
        session.invalidate();

        return "redirect:/";
    }
}
