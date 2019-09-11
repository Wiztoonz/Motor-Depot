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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FlightController extends HttpServlet {

    private static final Logger log = Logger.getLogger(FlightController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long time = System.currentTimeMillis();

        String carId = req.getParameter("carId");
        String description = req.getParameter("description");
        Date date = new Date(time);
        String status = req.getParameter("status");
        int userId = 0;

        if (!carId.equals("") && !description.equals("") && !status.equals("")) {
            try {

            Flight flight = new Flight(Integer.parseInt(carId), userId, description, date, status);
            FlightService flightService = new FlightService();
            flightService.createFlight(flight);
            String logCar = "";
            if (flight.getCarId() == 0) {
                logCar = "Not assigned";
            } else {
                logCar = String.valueOf(flight.getCarId());
            }
            String logUser = "";
            if (flight.getIdOfUser() == null) {
                logUser = "Not assigned";
            } else {
                logUser = flight.getIdOfUser();
            }
            log.info("Flight added: "
                    + " Flight status: " + flight.getStatus()
                    + ", Flight car id: " + logCar
                    + ", Flight driver: " + logUser);
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Невозможно создать рейс так как такой машины не существует в базе!");
            } catch (SQLException e) {
                log.error("*** flight add error ***");
                e.printStackTrace();
            }
        }

        resp.sendRedirect(Paths.ADMIN_PAGE);
    }

}
