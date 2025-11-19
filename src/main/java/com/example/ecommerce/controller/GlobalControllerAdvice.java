package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("userSession")
    public User getUserSession(HttpSession session){

        return (User) session.getAttribute("userSession");
    }
}
