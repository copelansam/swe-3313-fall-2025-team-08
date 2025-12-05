package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.UserRegistrationResult;
import com.example.ecommerce.model.UserSignInResult;
import com.example.ecommerce.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    public final UserEntityRepository userTable;

    public UserEntityService(UserEntityRepository userTable){

        this.userTable = userTable;

    }

    public UserSignInResult signIn(String username, String password){

        User signInResult = userTable.credentialsValid(username,password);

        if (signInResult == null){

            // check that the user input matches a record in the database, if not display a message
            return new UserSignInResult(false, "The provided username or password is incorrect. Please try again");
        }
        else{

            // otherwise, assign a user to the session based on the info we have on file
            return new UserSignInResult(true,null,signInResult);
        }
    }

    public UserRegistrationResult registerUser(String name, String username, String email, String password, String passwordConfirm){

        // validate user input and create a message to display if there is a problem
        if (name.length() > 100 || username.length() > 100 || email.length() > 100 || password.length() > 100 || passwordConfirm.length() > 100){

            return new UserRegistrationResult(false, "The character limit for each field is 100.");
        }
        if (name.isEmpty()){

            return new UserRegistrationResult(false,"Please enter a name");
        }
        if (email.isEmpty()){

            return new UserRegistrationResult(false,"Please enter an email");
        }
        if (username.isEmpty()){

            return new UserRegistrationResult(false,"Please enter a username");
        }
        if (password.isEmpty()){

            return new UserRegistrationResult(false,"Please enter a password");
        }
        if (passwordConfirm.isEmpty()){

            return new UserRegistrationResult(false,"Please enter the same password again");
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

        // if there is no problem with the user input, create a new user entity in the database and add the user to the current session
        // return the userId to store in the user object
        int userId = userTable.addRow(name, username, email, password);

        User userSession = new User(userId,name, username, email,false);

        return new UserRegistrationResult(true,null, userSession);

        }
}
