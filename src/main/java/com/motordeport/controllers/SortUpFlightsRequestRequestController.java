package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.comparators.FlightRequestUserDateComparator;
import com.motordeport.comparators.FlightsRequestRequestComparator;
import com.motordeport.comparators.FlightsRequestUserComparator;
import com.motordeport.models.request.Request;
import com.motordeport.models.user.User;
import com.motordeport.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUpFlightsRequestRequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("Admin") != null) {

            RequestService requestService = new RequestService();
            try {
                List<Request> requestList = requestService.selectUserRequest();
                Collections.sort(requestList, new FlightsRequestRequestComparator());
                session.setAttribute("ListUserRequest", requestList);
                req.getRequestDispatcher(Paths.ADMIN_FLIGHT_PAGE).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Dispatcher") != null) {

            RequestService  requestService = new RequestService();
            try {
                List<Request> requestList = requestService.selectUserRequest();
                Collections.sort(requestList, new FlightsRequestRequestComparator());
                session.setAttribute("ListUserRequest", requestList);
                req.getRequestDispatcher(Paths.DISPATCHER_FLIGHT_B_URL).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Driver") != null) {

            RequestService  requestService = new RequestService();
            try {
                User driver = (User) session.getAttribute("Driver");
                List<Request> requestList = requestService.selectUserRequest();
                Collections.sort(requestList, new FlightRequestUserDateComparator());
                List<Request> result = new ArrayList<>();
                for (Request request : requestList) {
                    if (request.getUserId() == driver.getId()) {
                        result.add(request);

                    }
                }
                session.setAttribute("UserReq", result);
                req.getRequestDispatcher(Paths.DRIVER_REQUEST_URL).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Admin") == null &&
                session.getAttribute("Dispatcher") == null &&
                session.getAttribute("Driver") == null) {
            resp.sendRedirect(Paths.LOGIN_NO_SESSION);
        }

    }

}
