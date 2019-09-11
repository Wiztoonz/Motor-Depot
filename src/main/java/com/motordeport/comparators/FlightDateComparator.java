package com.motordeport.comparators;

import com.motordeport.models.flight.Flight;

import java.util.Comparator;

public class FlightDateComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
}
