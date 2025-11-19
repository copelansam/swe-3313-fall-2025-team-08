package com.example.ecommerce.controller;


import com.example.ecommerce.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class HomePagesController {

    @GetMapping("/main")
    public String mainPage(){

        return "main";
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
