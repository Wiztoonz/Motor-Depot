package com.motordeport.controllers.filters;

import com.motordeport.Paths;
import com.motordeport.models.car.Car;
import com.motordeport.models.flight.Flight;
import com.motordeport.models.request.Request;
import com.motordeport.services.CarService;
import com.motordeport.services.FlightService;
import com.motordeport.services.RequestService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FlightDispatcherFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String rootPath = req.getContextPath();
        String userPath = req.getServletPath();
        String url = rootPath + userPath;

        HttpSession session = req.getSession();

        if (session.getAttribute("Dispatcher") != null) {
            if (url.equals(Paths.DISPATCHER_FLIGHT_URL)) {

                RequestService requestService = new RequestService();
                FlightService flightService = new FlightService();
                CarService carService = new CarService();
                try {
                    List<Request> listRequest = requestService.selectUserRequest();
                    List<Flight> flightLust = flightService.selectFlight();
                    List<Car> carList = carService.selectCar();
                    session.setAttribute("ListUserRequest", listRequest);
                    session.setAttribute("ListFlights", flightLust);
                    session.setAttribute("ListCars", carList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                req.getRequestDispatcher(Paths.FLIGHT_PAGE).forward(req,resp);
                filterChain.doFilter(req,resp);
            } else {
                resp.sendRedirect(Paths.LOGIN_NO_SESSION);
                filterChain.doFilter(req,resp);
            }
        } else {
            resp.sendRedirect(Paths.LOGIN_NO_SESSION);
            filterChain.doFilter(req,resp);
        }
    }

}
