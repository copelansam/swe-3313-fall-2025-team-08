package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.PromoteUserService;
import com.example.ecommerce.service.UserEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PromoteUserController {

    public final PromoteUserService promoteUserService;

    PromoteUserController(PromoteUserService promoteUserService){

        this.promoteUserService = promoteUserService;
    }

    // Display the promote user screen
    @GetMapping("/display-user")
    public String displayUsers(Model model){

        List<User> users = promoteUserService.displayNonAdmins();

        model.addAttribute("users", users);

        return "promote-user";
    }

    // Promote the non admin user that the admin selected
    @PostMapping("/promote")
    public String promoteUser(@RequestParam("selectedUser") String username, Model model){

        promoteUserService.promoteUser(username);

        List<User> users = promoteUserService.displayNonAdmins();

        model.addAttribute("users", users);

        return "redirect:/display-user";
    }
}
