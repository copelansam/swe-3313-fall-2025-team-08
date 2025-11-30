package com.example.ecommerce.controller;


import com.example.ecommerce.model.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPagesController {



    @GetMapping("/payment")
    public String payment(Model model, HttpSession session){

        Cart cart = (Cart) session.getAttribute("cart");

        model.addAttribute("cart", cart);

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
