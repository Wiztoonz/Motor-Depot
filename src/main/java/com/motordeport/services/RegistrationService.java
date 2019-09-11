package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationService {

    private static final String INSERT_REGISTER = "INSERT INTO Users (First_name, Second_name, Password, Email, Role) VALUES (?,?,?,?,?)";

    public void registration(User user) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REGISTER);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getSecondName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.executeUpdate();
    }

}