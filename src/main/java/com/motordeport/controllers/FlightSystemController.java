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

public class FlightSystemController extends HttpServlet {

    private static final Logger log = Logger.getLogger(FlightSystemController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String numberEdit = req.getParameter("numberEdit");
        String statusEdit = req.getParameter("statusEdit");

        if (!numberEdit.equals("") && !statusEdit.equals("")) {
            try {
                Flight flight = new Flight(statusEdit, Integer.parseInt(numberEdit));
                FlightService flightService = new FlightService();
                flightService.editUserFlight(flight);

                String logCar;
                if (flight.getCarId() == 0) {
                    logCar = "Not assigned";
                } else {
                    logCar = String.valueOf(flight.getCarId());
                }
                log.info("Flight admin or dispatcher status edited to db: "
                        + " Flight number: " + flight.getFlightsNumber()
                        + ", Flight status: " + flight.getStatus()
                        + ", Flight car id: " + logCar
                        + ", Flight driver: " + flight.getIdOfUser());
            } catch (SQLException e) {
                log.error("*** flight admin or dispatcher status edit error to db ***");
                e.printStackTrace();
            }
        }

        resp.sendRedirect(Paths.ADMIN_PAGE);

    }

}
