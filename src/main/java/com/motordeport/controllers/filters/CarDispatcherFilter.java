package com.motordeport.controllers.filters;

import com.motordeport.Paths;
import com.motordeport.models.car.Car;
import com.motordeport.models.flight.Flight;
import com.motordeport.models.request.Request;
import com.motordeport.models.user.User;
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

public class CarDispatcherFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String rootPath = req.getContextPath();
        String userPath = req.getServletPath();
        String url = rootPath + userPath;

        HttpSession session = req.getSession();

        if (session.getAttribute("Dispatcher") != null) {
            if (url.equals(Paths.DISPATCHER_CAR_URL)) {


                CarService carService = new CarService();
                try {
                    List<Car> carList = carService.selectCar();
                    session.setAttribute("ListCars", carList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                req.getRequestDispatcher(Paths.CAR_PAGE).forward(req,resp);
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
