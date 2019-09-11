package com.motordeport.controllers.validators;

import com.motordeport.Paths;
import com.motordeport.models.user.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginValidator extends HttpServlet {

    private static final Logger log = Logger.getLogger(LoginValidator.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();

        if (session != null) {
            User user = (User) req.getAttribute("user");
            switch (user.getRole()) {
                case "Driver":
                    session.setAttribute("Driver", user);
                    resp.sendRedirect(Paths.DRIVER_PAGE);
                    break;
                case "Admin":
                    session.setAttribute("Admin", user);
                    log.info("Admin loginned :"
                            + " ID: " + user.getId()
                            + ", Name: " + user.getFirstName()
                            + ", Second name: " + user.getSecondName()
                            + ", Email " + user.getEmail());
                    resp.sendRedirect(Paths.ADMIN_PAGE);
                    break;
                case "Dispatcher":
                    session.setAttribute("Dispatcher", user);
                    log.info("Dispatcher loginned :"
                            + " ID: " + user.getId()
                            + ", Name: " + user.getFirstName()
                            + ", Second name: " + user.getSecondName()
                            + ", Email " + user.getEmail());
                    resp.sendRedirect(Paths.DISPATCHER_PAGE);
                    break;
            }

        }
    }
}
