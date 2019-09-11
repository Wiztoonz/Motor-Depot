package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AssignmentController extends HttpServlet {

    private static final Logger log = Logger.getLogger(AssignmentController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userAddId");
        String numberFlight = req.getParameter("numberAddFlight");

        if (!userId.equals("") && !numberFlight.equals("")) {

            Flight flight = new Flight(Integer.parseInt(numberFlight), Integer.parseInt(userId));
            FlightService flightService = new FlightService();
            try {
                flightService.editFlight(flight);
                String logCar = "";
                if (flight.getCarId() == 0) {
                    logCar = "Not assigned";
                } else {
                    logCar = String.valueOf(flight.getCarId());
                }
                log.info("Flight assignment: Flight number: " + flight.getFlightsNumber());
            } catch (SQLException e) {
                log.error("*** flight assignment error ***");
                e.printStackTrace();
            }
        }

        resp.sendRedirect(Paths.MAIN_PAGE);
    }

}
