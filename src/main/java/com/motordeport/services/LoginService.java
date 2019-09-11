package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    private static final String SELECT_LOGIN = "SELECT * FROM Users WHERE email = ? AND password = ?";

    public User login(String userEmail, String userPassword) throws SQLException {

        Connection connection = DbUtil.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN);
        preparedStatement.setString(1, userEmail);
        preparedStatement.setString(2, userPassword);
        ResultSet info = preparedStatement.executeQuery();

        User user = new User();

        while (info.next()) {
            int id = info.getInt("Id");
            String firstName = info.getString("First_name");
            String secondName = info.getString("Second_name");
            String email = info.getString("email");
            String password = info.getString("password");
            String role = info.getString("Role");

            if (email.equals(userEmail) && password.equals(userPassword)) {
                user.setId(id);
                user.setFirstName(firstName);
                user.setSecondName(secondName);
                user.setPassword(password);
                user.setEmail(email);
                user.setRole(role);
            }
        }
        return user;
    }


}