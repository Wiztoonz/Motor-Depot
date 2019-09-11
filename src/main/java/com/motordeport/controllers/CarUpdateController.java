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

public class CarUpdateController extends HttpServlet {

    private static final Logger log = Logger.getLogger(CarUpdateController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carId = req.getParameter("carId").trim();
        String descriptionUpdate = req.getParameter("descriptionUpdate").trim();
        String statusUpdate = req.getParameter("statusUpdate").trim();
        String carUpdate = req.getParameter("carUpdate").trim();


        if (!carId.equals("") && !descriptionUpdate.equals("") && !statusUpdate.equals("") && !carUpdate.equals("")) {
            try {
                Car car = new Car(Integer.parseInt(carId), descriptionUpdate, carUpdate, statusUpdate);
                CarService carService = new CarService();
                carService.editCar(car);
                log.info("Car edited to DB:"
                        + " ID: " + car.getId()
                        + ", Car: " + car.getCar());
            } catch (SQLException e) {
                log.error("*** car edit error to db ***");
                e.printStackTrace();
            }
        }

        resp.sendRedirect(Paths.ADMIN_PAGE);
    }

}
