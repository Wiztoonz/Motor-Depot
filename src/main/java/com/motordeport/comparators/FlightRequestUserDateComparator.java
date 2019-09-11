package com.motordeport.comparators;

import com.motordeport.models.request.Request;

import java.util.Comparator;

public class FlightRequestUserDateComparator implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
}
