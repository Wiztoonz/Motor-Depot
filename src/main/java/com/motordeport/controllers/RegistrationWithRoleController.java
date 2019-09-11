package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.models.user.User;
import com.motordeport.services.RegistrationService;
import org.apache.catalina.manager.StatusManagerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationWithRoleController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName").trim();
        String secondName = req.getParameter("secondName").trim();
        String password = req.getParameter("password").trim();
        String email = req.getParameter("email").trim();
        String role = req.getParameter("role").trim();

        String message1 = "language.emailValid";
        String message2 = "language.emailTrue";
        boolean flag = true;
        String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Matcher matcher = Pattern.compile(regex).matcher(email);
        if (matcher.matches()) {
            flag = false;
        }

        if (!flag) {

            if (!firstName.equals("") && !secondName.equals("") && !password.equals("") && !email.equals("") && !role.equals("")) {

                try {

                    User user = new User(firstName, secondName, password, email, role);
                    RegistrationService registrationService = new RegistrationService();
                    registrationService.registration(user);
                } catch (SQLIntegrityConstraintViolationException e) {
                    req.setAttribute("email", message1);
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    req.getRequestDispatcher(Paths.ADMIN_REGISTRATION_PAGE).forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                req.getRequestDispatcher(Paths.ADMIN_REGISTRATION_PAGE).forward(req, resp);
            }
        } else {
            req.setAttribute("emailTrue", message2);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.getRequestDispatcher(Paths.ADMIN_REGISTRATION_PAGE).forward(req, resp);
        }
        resp.sendRedirect(Paths.ADMIN_PAGE);
    }

}
