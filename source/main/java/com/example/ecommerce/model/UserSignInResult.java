package com.example.ecommerce.model;

// This class will track the success of a users attempt to sign in,
// the message field will be assigned with an error message to match what went wrong

public class UserSignInResult {

    private boolean success;

    private String message;

    private User user;

    public UserSignInResult(boolean success,String message){

        this.success = success;

        this.message = message;

        this.user = null;
    }

    public UserSignInResult(boolean success, String message, User user){

        this.success = success;

        this.message = message;

        this.user = user;
    }

    public boolean getSuccess(){

        return this.success;
    }

    public String getMessage(){

        return this.message;
    }

    public User getUser(){

        return this.user;
    }
}
