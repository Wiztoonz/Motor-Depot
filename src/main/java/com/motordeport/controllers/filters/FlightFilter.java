package com.motordeport.controllers.filters;


import com.motordeport.models.flight.Flight;
import com.motordeport.models.user.User;
import com.motordeport.services.FlightService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();


        try {
            if (session.getAttribute("Driver") != null) {

                FlightService flightService = new FlightService();
                List<Flight> list = flightService.selectFlight();

                List<Flight> userListFlight = new ArrayList<>();
                User user = (User) session.getAttribute("Driver");

                for (Flight flight : list) {
                   if (user.getId() == flight.getUserId()) {
                       userListFlight.add(flight);
                   }
                }
                session.setAttribute("Flights", list);
                session.setAttribute("FlightsUser", userListFlight);
                session.setAttribute("FlightUserReq", userListFlight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
