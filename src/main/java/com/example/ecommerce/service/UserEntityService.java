package com.example.ecommerce.service;

import com.example.ecommerce.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    public final UserEntityRepository userTable;

    public UserEntityService(UserEntityRepository userTable){

        this.userTable = userTable;
    }
}
