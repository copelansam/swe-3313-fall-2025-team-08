package com.example.ecommerce.repository;


import com.example.ecommerce.model.Admin;
import com.example.ecommerce.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbc;

    public UserEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;

    }

    public int addRow(String name, String userName, String email, String password) {

        String userSql = "INSERT INTO User(name, userName, email, password, isAdmin) VALUES (?, ?, ?, ?, FALSE)";

        jdbc.update(userSql, name, userName, email, password);

        String getUserId = "SELECT userID FROM User WHERE userName = ?";

        return jdbc.queryForObject(getUserId,Integer.class,userName);

    }

    public User credentailsValid(String userName, String password){

        String findUserSql = "SELECT * FROM User WHERE userName = ? AND password = ?";

        // see if user input username/password cominbation exist and create a user item based on results
        try{

            return jdbc.queryForObject(findUserSql,
                    new Object[]{userName,password},
                    (rs, rowNum) -> {

                        boolean isAdmin = rs.getInt("isAdmin") != 0;

                        String name = rs.getString("name");

                        String username = rs.getString("userName");

                        String email = rs.getString("email");

                        int userId = rs.getInt("userId");

                        if (isAdmin){

                            return new Admin(userId,name, username,email);
                        }
                        else{

                            return new User(userId,name,username,email,false);
                        }
                    }
                    );
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean usernameUnique(String userName){

        String usernameUniqueSql = "SELECT Count(*) FROM User WHERE userName = ?";

        int usernameOccurrence = jdbc.queryForObject(usernameUniqueSql, Integer.class, userName);

        return usernameOccurrence == 0;

    }

    public List<User> nonAdminUsers(){

        String query = "SELECT username, name FROM User WHERE isAdmin = false";

        return jdbc.query(query, ((rs, rowNum) -> {

            User user = new User();

            user.setName(rs.getString("name"));

            user.setUsername(rs.getString("username"));

            return user;
        }));
    }

    public void promoteUser(String username){

        String query = "UPDATE User SET isAdmin = true WHERE userName = ?";

        jdbc.update(query, username);
    }
}
