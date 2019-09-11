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

public class CarController extends HttpServlet {

    private static final Logger log = Logger.getLogger(CarController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carParam = req.getParameter("car").trim();
        String carStatusParam = req.getParameter("carStatus").trim();
        String descriptionParam = req.getParameter("description").trim();

        if (!carParam.equals("") && !carStatusParam.equals("")) {

            try {

                if (descriptionParam.equals("")) {
                    descriptionParam = "No description.";
                }

                Car car = new Car(carParam,carStatusParam,descriptionParam);
                CarService carService = new CarService();
                carService.createCar(car);
                log.info("Car added to DB:"
                        + " Car: " + car.getCar()
                        + " Description: " + car.getDescription());
            } catch (SQLException e) {
                log.error("*** car add to db error ***");
                e.printStackTrace();
            }

        }

        resp.sendRedirect(Paths.ADMIN_PAGE);
    }

}
