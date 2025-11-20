package com.example.ecommerce.model;

// This class was created under the suggestion of ChatGPT and will be used to record
// the progress of user attempts to create an account

public class UserRegistrationResult {

    private boolean success;

    private String message;

    private User user;

    public UserRegistrationResult(boolean success, String message){

        this.success = success;

        this.message = message;

        this.user = null;
    }

    public UserRegistrationResult(boolean success, String message, User user){

        this.success = success;

        this.message = message;

        this.user = user;
    }

    public boolean getSuccess(){

        return success;

    }

    public String getMessage(){

        return message;

    }

    public User getUser(){

        return user;
    }
}
