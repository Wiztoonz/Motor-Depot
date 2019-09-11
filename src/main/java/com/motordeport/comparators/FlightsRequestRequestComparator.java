package com.motordeport.comparators;

import com.motordeport.models.request.Request;

import java.util.Comparator;

public class FlightsRequestRequestComparator implements Comparator<Request> {

    @Override
    public int compare(Request o1, Request o2) {
        return Integer.compare(o1.getFlightNumber(), o2.getFlightNumber());
    }

}
