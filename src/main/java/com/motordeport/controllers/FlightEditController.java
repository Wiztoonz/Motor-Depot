package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.models.flight.Flight;
import com.motordeport.models.request.Request;
import com.motordeport.services.FlightService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightEditController extends HttpServlet {

    private static final Logger log = Logger.getLogger(FlightEditController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String numberEdit = req.getParameter("numberEdit");
        String statusEdit = req.getParameter("statusEdit");
        boolean flag = true;
        HttpSession session = req.getSession();
        List<Flight> userReq = (ArrayList) session.getAttribute("FlightUserReq");

        for (Flight userR : userReq) {
            if (Integer.parseInt(numberEdit) != userR.getFlightsNumber()) {
                continue;
            }
            flag = false;
        }

        if (!flag) {
            if (!numberEdit.equals("") && !statusEdit.equals("")) {
                try {
                    Flight flight = new Flight(statusEdit, Integer.parseInt(numberEdit));
                    FlightService flightService = new FlightService();
                    flightService.editUserFlight(flight);

                    log.info("Flight user status edited: "
                            + " Flight number: " + flight.getFlightsNumber()
                            + ", Flight status: " + flight.getStatus());
                } catch (SQLException e) {
                    log.error("*** flight user status edit error ***");
                    e.printStackTrace();
                }

            }
        }

        resp.sendRedirect(Paths.ADMIN_PAGE);

    }

}
