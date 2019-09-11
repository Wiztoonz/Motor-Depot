package com.motordeport.services.cars;

import com.motordeport.models.car.Car;

import java.util.List;

public class SortCars {

    public static List<Car> getBCars() {
        return BCars.getBCars();
    }

    public static List<Car> getBECars() {
        return BECars.getBECars();
    }

    public static List<Car> getCCars() {
        return CCars.getCCars();
    }

    public static List<Car> getCECars() {
        return CECars.getCECars();
    }

}
