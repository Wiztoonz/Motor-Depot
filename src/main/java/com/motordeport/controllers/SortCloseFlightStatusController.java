package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.services.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SortCloseFlightStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("Admin") != null) {
            session.setAttribute("ListFlights", FlightService.closeFlights());
            req.getRequestDispatcher(Paths.ADMIN_FLIGHT_PAGE).forward(req,resp);
        }

        if (session.getAttribute("Dispatcher") != null) {
            session.setAttribute("ListFlights", FlightService.closeFlights());
            req.getRequestDispatcher(Paths.DISPATCHER_FLIGHT_PAGE).forward(req,resp);
        }

        if (session.getAttribute("Driver") != null) {
            session.setAttribute("Flights", FlightService.closeFlights());
            req.getRequestDispatcher(Paths.DRIVER_REQUEST_URL).forward(req,resp);
        }

        if (session.getAttribute("Admin") == null &&
                session.getAttribute("Dispatcher") == null &&
                session.getAttribute("Driver") == null) {
            resp.sendRedirect(Paths.LOGIN_NO_SESSION);
        }

    }

}
