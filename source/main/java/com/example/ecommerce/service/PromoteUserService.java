package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PromoteUserService {

    private final UserEntityRepository userTable;

    public PromoteUserService(UserEntityRepository userTable){

        this.userTable = userTable;
    }

    // retrieve all non admin users to display
    public List<User> displayNonAdmins(){

        return userTable.nonAdminUsers();
    }

    public void promoteUser(String username){

        // promote specified user to admin
        userTable.promoteUser(username);
    }
}
