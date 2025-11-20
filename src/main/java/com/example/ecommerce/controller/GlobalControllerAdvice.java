package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
// This class was created by ChatGPT and will be used to keep track of
// global model attributes sourced from the session so that Thymeleaf can access their data.
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("userSession")
    public User getUserSession(HttpSession session){

        return (User) session.getAttribute("userSession");
    }
}
