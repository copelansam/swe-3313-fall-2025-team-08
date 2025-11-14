package com.example.ecommerce.controller;

import com.example.ecommerce.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// Passes the create account screen to the view
@Controller
public class UserAuthController {

    // injects the user service
    public final UserService userService;

    // constructor for dependency injection
    public UserAuthController(UserService userService){
        this.userService = userService;
    }

    // directs the system to display the sign in screen
    @GetMapping("/")
    public String signIn(){

        return "index";
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password){


        return "redirect:/home";
    }




    // directs the system to display the create account screen
    @GetMapping("/create-account")
    public String signUp(){

        return "create-account";
    }

    @PostMapping("create-account")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String passwordConfirm){

        //userService.method to create a user in the database (To Be Updated)

        return "redirect:/home";

    }
}
