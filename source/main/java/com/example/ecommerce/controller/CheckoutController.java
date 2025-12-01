package com.example.ecommerce.controller;


import com.example.ecommerce.model.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {



    @GetMapping("/payment")
    public String payment(Model model, HttpSession session){

        Cart cart = (Cart) session.getAttribute("cart");

        model.addAttribute("cart", cart);

        return "payment2";
    }

    @PostMapping("/process-payment")
    public String processPayment(Model model, HttpSession session){

        Cart cart = (Cart) session.getAttribute("cart");

        model.addAttribute("cart",cart);

        return "confirm";
    }

    @GetMapping("/confirm")
    public String confirm(){

        return "confirm";
    }

    @PostMapping("/confirm-order")
    public String displayReceipt(Model model, HttpSession session){

        return "receipt";

    }

    @GetMapping("/receipt")
    public String receipt(){
        return "receipt";
    }
}
