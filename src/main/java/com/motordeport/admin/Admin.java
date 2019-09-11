package com.motordeport.admin;

import com.motordeport.Paths;
import com.motordeport.models.user.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Admin {

    public User createAdmin() {
        User admin = new User();
        Properties properties = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Paths.ADMIN_PROPERTIES);
            properties.load(inputStream);
            String firstName = properties.getProperty("First.name").trim();
            String secondName = properties.getProperty("Second.name").trim();
            String password = properties.getProperty("Password").trim();
            String email = properties.getProperty("Email").trim();
            String role = properties.getProperty("Role").trim();
            admin.setFirstName(firstName);
            admin.setSecondName(secondName);
            admin.setPassword(password);
            admin.setEmail(email);
            admin.setRole(role);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }

}
