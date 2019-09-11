package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.comparators.FlightDateComparator;
import com.motordeport.comparators.FlightNumbersComparator;
import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class SortUpNumberFlightController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String forwardPath = String.valueOf(req.getAttribute("forwardPath"));

        if (session.getAttribute("Admin") != null) {

            FlightService flightService = new FlightService();
            try {
                List<Flight> flightList = flightService.selectFlight();
                Collections.sort(flightList, new FlightDateComparator());
                session.setAttribute("ListFlights", flightList);
                req.getRequestDispatcher(forwardPath).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Dispatcher") != null) {

            FlightService flightService = new FlightService();
            try {
                List<Flight> flightList = flightService.selectFlight();
                Collections.sort(flightList, new FlightDateComparator());
                session.setAttribute("ListFlights", flightList);
                req.getRequestDispatcher(forwardPath).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Driver") != null) {

            FlightService flightService = new FlightService();
            try {
                List<Flight> flightList = flightService.selectFlight();
                Collections.sort(flightList, new FlightNumbersComparator());
                session.setAttribute("Flights", flightList);
                req.getRequestDispatcher(forwardPath).forward(req,resp);
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
