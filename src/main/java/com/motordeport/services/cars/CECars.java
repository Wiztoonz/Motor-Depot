package com.motordeport.services.cars;

import com.motordeport.models.car.Car;
import com.motordeport.services.CarService;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CECars {

    public static List<Car> getCECars() {
        CarService carService = new CarService();
        List<Car> BList = new CopyOnWriteArrayList<>();
        try {
            List<Car> carList = carService.selectCar();
            for (Car car : carList) {
                if (car.getCarStatus().equalsIgnoreCase("CE")) {
                    BList.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return BList;
    }

}
