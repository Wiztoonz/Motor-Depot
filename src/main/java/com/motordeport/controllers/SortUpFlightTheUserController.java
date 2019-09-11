package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.comparators.FlightCarComparator;
import com.motordeport.comparators.FlightDateComparator;
import com.motordeport.models.car.Car;
import com.motordeport.models.flight.Flight;
import com.motordeport.models.user.User;
import com.motordeport.services.CarService;
import com.motordeport.services.FlightService;

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

public class SortUpFlightTheUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("Admin") != null) {

            CarService carService = new CarService();
            try {
                List<Car> carList = carService.selectCar();
                Collections.sort(carList, new FlightCarComparator());
                session.setAttribute("ListCars", carList);
                req.getRequestDispatcher(Paths.ADMIN_FLIGHT_B_URL).forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Dispatcher") != null) {

            CarService carService = new CarService();
            try {
                List<Car> carList = carService.selectCar();
                Collections.sort(carList, new FlightCarComparator().reversed());
                session.setAttribute("ListCars", carList);
                req.getRequestDispatcher(Paths.DISPATCHER_FLIGHT_B_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        if (session.getAttribute("Driver") != null) {

            FlightService flightService = new FlightService();
            try {
                User driver = (User) session.getAttribute("Driver");
                List<Flight> requestList = flightService.selectFlight();
                Collections.sort(requestList, new FlightDateComparator());
                List<Flight> result = new ArrayList<>();
                for (Flight request : requestList) {
                    if (request.getUserId() == driver.getId()) {
                        result.add(request);

                    }
                }
                session.setAttribute("FlightsUser", result);
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
