package com.motordeport.controllers.filters;

import com.motordeport.Paths;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarSortUrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String rootPath = req.getContextPath();
        String userPath = req.getServletPath();
        String url = rootPath + userPath;

        String forwardPath = "";

        switch (url) {
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortBCars":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortBECars":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortCCars":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortCECars":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortUpFlightNumbers":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortDownFlightNumbers":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortUpFightDates":
            case "/MotorDepot" + Paths.ADMIN_FLIGHT_B_URL + "/sortDownFightDates":
                forwardPath = Paths.ADMIN_FLIGHT_B_URL;
                break;
            case "/MotorDepot" + Paths.ADMIN_CAR_B_URL + "/sortBCars":
            case "/MotorDepot" + Paths.ADMIN_CAR_B_URL + "/sortBECars":
            case "/MotorDepot" + Paths.ADMIN_CAR_B_URL + "/sortCCars":
            case "/MotorDepot" + Paths.ADMIN_CAR_B_URL + "/sortCECars":
                forwardPath = Paths.ADMIN_CAR_B_URL;
                break;
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortBCars":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortBECars":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortCCars":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortCECars":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortUpFlightNumbers":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortDownFlightNumbers":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortUpFightDates":
            case "/MotorDepot" + Paths.DISPATCHER_FLIGHT_B_URL + "/sortDownFightDates":
                forwardPath = Paths.DISPATCHER_FLIGHT_B_URL;
                break;
            case "/MotorDepot" + Paths.DISPATCHER_CAR_B_URL + "/sortBCars":
            case "/MotorDepot" + Paths.DISPATCHER_CAR_B_URL + "/sortBECars":
            case "/MotorDepot" + Paths.DISPATCHER_CAR_B_URL + "/sortCCars":
            case "/MotorDepot" + Paths.DISPATCHER_CAR_B_URL + "/sortCECars":
                forwardPath = Paths.DISPATCHER_CAR_B_URL;
                break;
            case "/MotorDepot" + Paths.DRIVER_REQUEST_URL + "/sortUpFightDates":
            case "/MotorDepot" + Paths.DRIVER_REQUEST_URL + "/sortDownFightDates":
            case "/MotorDepot" + Paths.DRIVER_REQUEST_URL + "/sortDownFlightNumbers":
            case "/MotorDepot" + Paths.DRIVER_REQUEST_URL + "/sortUpFlightNumbers":
                forwardPath = Paths.DRIVER_REQUEST_URL;
                break;
        }

        req.setAttribute("forwardPath",forwardPath);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
