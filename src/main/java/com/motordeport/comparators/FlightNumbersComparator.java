package com.motordeport.comparators;

import com.motordeport.models.flight.Flight;

import java.util.Comparator;

public class FlightNumbersComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return Integer.compare(o1.getFlightsNumber(), o2.getFlightsNumber());
    }
}
