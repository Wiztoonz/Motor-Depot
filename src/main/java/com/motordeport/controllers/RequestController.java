package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.models.request.Request;
import com.motordeport.models.user.User;
import com.motordeport.services.RequestService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class RequestController extends HttpServlet {

    private static final Logger log = Logger.getLogger(RequestController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long time = System.currentTimeMillis();

        User driver = (User) session.getAttribute("Driver");

        String flightNumber = req.getParameter("flightNumber").trim();
        String carCharacteristics = req.getParameter("carCharacteristics").trim();
        Date date = new Date(time);
        int userId = driver.getId();

        if (!flightNumber.equals("") && !carCharacteristics.equals("")) {
            try {
                Request request = new Request(Integer.parseInt(flightNumber), carCharacteristics, date, userId);
                RequestService requestService = new RequestService();
                requestService.createRequest(request);
                log.info("Request created: "
                        + " Flight number: " + request.getFlightNumber()
                        + ", User id: " + request.getUserId());
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Такого рейса не существует!");
            } catch (SQLException e) {
                log.error("*** request create error ***");
                e.printStackTrace();
            }
        }
        resp.sendRedirect(Paths.DRIVER_PAGE);
    }

}
