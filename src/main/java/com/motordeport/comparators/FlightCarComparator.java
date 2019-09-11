package com.motordeport.comparators;

import com.motordeport.models.car.Car;

import java.util.Comparator;

public class FlightCarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
