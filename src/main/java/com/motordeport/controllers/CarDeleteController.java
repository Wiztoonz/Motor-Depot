package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.models.car.Car;
import com.motordeport.services.CarService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CarDeleteController extends HttpServlet {

    private static final Logger log = Logger.getLogger(CarDeleteController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carDeleteId = req.getParameter("carDeleteId");

        if (!carDeleteId.equals("")) {
            try {
                Car car = new Car(Integer.parseInt(carDeleteId));
                CarService carService = new CarService();
                carService.deleteCar(car);
                log.info("Car deleted form DB: "
                        + " ID: " + car.getId()
                        + ", Car: " + car.getCar());
            } catch (SQLException e) {
                log.error("*** car delete error from db ***");
                e.printStackTrace();
            }

        }

        resp.sendRedirect(Paths.ADMIN_PAGE);
    }

}
