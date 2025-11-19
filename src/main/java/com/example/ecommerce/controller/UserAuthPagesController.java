package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// Passes the create account screen to the view
@Controller
public class UserAuthPagesController {

    // injects the user service
    public final UserEntityService userEntityService;

    // constructor for dependency injection
    public UserAuthPagesController(UserEntityService userEntityService){
        this.userEntityService = userEntityService;
    }

    // directs the system to display the sign in screen
    @GetMapping("/")
    public String signIn(Model model){
        User userSession = new User();
        return "login";
    }

    @PostMapping("/login")
    public void login(@RequestParam String username,
                      @RequestParam String password, Model model){

     //   if (/*userService.(query that checks if a record exists with the specified username and password)*/){
            
       // }

    }




    // directs the system to display the create account screen
    @GetMapping("/create-account")
    public String signUp(){

        return "create-account";
    }

    @PostMapping("register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               Model model){

        if(name.isEmpty()){
            model.addAttribute("nameEmpty","Please enter a name");
            return "create-account";
        }
        else if(email.isEmpty()){
            model.addAttribute("emailEmpty","Please enter an email");
            return "create-account";
        }
        else if(username.isEmpty()){
            model.addAttribute("usernameEmpty","Please enter a username");
            return "create-account";
        }
        else if(password.isEmpty()){
            model.addAttribute("passwordEmpty","Please enter a password");
            return "create-account";
        }
        else if (confirmPassword.isEmpty()){
            model.addAttribute("confirmPasswordEmpty","Please enter the password again");
            return "create-account";
        }
        else if (username.length()<6){ // this condition will be changed to make sure that the username is unique, current condition is just for testing
            model.addAttribute("usernameInvalid","That username is already taken. " +
                    "Please try another one");
            return "create-account";
        }
        else if(password.length()<6){
            model.addAttribute("passwordLengthInvalid","Password must be " +
                    "at least 6 characters");
            return "create-account";
        }
        else if (!password.equals(confirmPassword)){
            model.addAttribute("passwordMismatch","Password and confirm" +
                    " password must match");
            return "create-account";
        }
        else{
            //userService.method to create a user in the database (To Be Updated)
            User userSession = new User();
            return "redirect:/main";
        }
    }
}
