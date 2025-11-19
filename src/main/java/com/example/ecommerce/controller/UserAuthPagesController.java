package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRegistrationResult;
import com.example.ecommerce.service.UserEntityService;
import jakarta.servlet.http.HttpSession;
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
    public UserAuthPagesController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    // directs the system to display the sign in screen
    @GetMapping("/")
    public String signIn(Model model) {
        //User userSession = new User();
        return "login";
    }

    @PostMapping("/login")
    public void login(@RequestParam String username,
                      @RequestParam String password, Model model) {

        //   if (/*userService.(query that checks if a record exists with the specified username and password)*/){

        // }

    }


    // directs the system to display the create account screen
    @GetMapping("/create-account")
    public String signUp() {

        return "create-account";
    }

    @PostMapping("register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               HttpSession session,
                               Model model) {

        UserRegistrationResult registerUser = userEntityService.registerUser(name, username, email, password, confirmPassword);

        if (!registerUser.getSuccess()) {

            model.addAttribute("errorMessage", registerUser.getMessage());

            return "create-account";
        }

        session.setAttribute("userSession", registerUser.getUser());
        return "redirect:/main";
    }
}
