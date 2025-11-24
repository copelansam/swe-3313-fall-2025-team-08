package com.example.ecommerce.repository;


import com.example.ecommerce.model.Admin;
import com.example.ecommerce.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserEntityRepository {

    private final JdbcTemplate jdbc;

    public UserEntityRepository(JdbcTemplate jdbc){

        this.jdbc = jdbc;

    }

    public void addRow(String name, String userName, String email, String password) {

        String userSql = "INSERT INTO User(name, userName, email, password, isAdmin) VALUES (?, ?, ?, ?, FALSE)";

        jdbc.update(userSql, name, userName, email, password);

    }

    public User credentailsValid(String userName, String password){

        String findUserSql = "SELECT * FROM User WHERE userName = ? AND password = ?";

        try{
            return jdbc.queryForObject(findUserSql,
                    new Object[]{userName,password},
                    (rs, rowNum) -> {
                        boolean isAdmin = rs.getInt("isAdmin") != 0;
                        String name = rs.getString("name");
                        String username = rs.getString("userName");
                        String email = rs.getString("email");

                        if (isAdmin){
                            return new Admin(name, username,email);
                        }
                        else{
                            return new User(name,username,email,false);
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
}
