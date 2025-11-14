package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin-actions")
    public String adminActoins(){

        return "admin-actions";
    }

    @GetMapping("/promote-user")
    public String promoteUser(){

        return "promote-user";
    }

    @GetMapping("/input-inventory")
    public String inputInventory(){

        return "input-inventory";
    }

    @GetMapping("/run-report")
    public String runReport(){

        return "run-report";
    }
}
