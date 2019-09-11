package com.motordeport.controllers.filters;

import com.motordeport.models.request.Request;
import com.motordeport.models.user.User;
import com.motordeport.services.RequestService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDriverFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("Driver") != null) {
                User driver = (User) session.getAttribute("Driver");
                RequestService requestService = new RequestService();
                List<Request> userRequest = requestService.selectUserRequest();
                List<Request> list = new ArrayList<>();
                for (Request req : userRequest) {
                    if (req.getUserId() == driver.getId()) {
                        list.add(req);
                        session.setAttribute("UserReq", list);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
