package com.motordeport.controllers.listeners;

import com.motordeport.admin.Admin;
import com.motordeport.dao.DbUtil;
import com.motordeport.models.user.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminListener implements ServletContextListener {

    private static final String INSERT_REGISTER = "INSERT IGNORE INTO Users (First_name, Second_name, Password, Email, Role) VALUES (?,?,?,?,?)";


    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Admin admin = new Admin();
        User userAdmin = admin.createAdmin();
        String firstName = userAdmin.getFirstName();
        String secondName = userAdmin.getSecondName();
        String password = userAdmin.getPassword();
        String email = userAdmin.getEmail();
        String role = userAdmin.getRole();

        try {
            if (!firstName.equals("") && !secondName.equals("") && !password.equals("") && !email.equals("")) {
                Connection connection = DbUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REGISTER);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, secondName);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, role);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
