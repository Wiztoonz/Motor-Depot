package com.motordeport.controllers.filters;

import com.motordeport.Paths;
import com.motordeport.models.user.User;
import com.motordeport.services.LoginService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            LoginService loginService = new LoginService();
            User user = loginService.login(email, password);
            if (user.getEmail() == null && user.getPassword() == null) {
                request.getRequestDispatcher(Paths.LOGIN).forward(servletRequest, servletResponse);
            } else {
                request.setAttribute("user", user);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
