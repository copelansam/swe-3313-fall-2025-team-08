package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRegistrationResult;
import com.example.ecommerce.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    public final UserEntityRepository userTable;

    public UserEntityService(UserEntityRepository userTable){

        this.userTable = userTable;
    }

    public UserRegistrationResult registerUser(String name, String username, String email, String password, String passwordConfirm){
        if (name.isEmpty()){

            return new UserRegistrationResult(false,"Please enter a name");
        }
        if (email.isEmpty()){

            return new UserRegistrationResult(false,"PLease enter an email");
        }
        if (username.isEmpty()){

            return new UserRegistrationResult(false,"PLease enter a username");
        }
        if (password.isEmpty()){

            return new UserRegistrationResult(false,"Please enter a password");
        }
        if (passwordConfirm.isEmpty()){

            return new UserRegistrationResult(false,"PLease enter the same password again");
        }
        if (!password.equals(passwordConfirm)){

            return new UserRegistrationResult(false,"The passwords must match", null);
        }
        if (password.length() < 6){

            return new UserRegistrationResult(false, "Password must be at least 6 characters", null);
        }
        if (!userTable.usernameUnique(username)){

            return new UserRegistrationResult(false, "That username is already taken. Please choose another one", null);
        }
        userTable.addRow(name, username, email, password);
        User userSession = new User(name, username, email);
        return new UserRegistrationResult(true,null, userSession);

        }
}
