package com.motordeport.services.flights;

import com.motordeport.models.flight.Flight;

import java.util.List;

public class SortFlights {

    public static List<Flight> getOpenFlights() {
        return OpenFlights.getOpenFlights();
    }

    public static List<Flight> getCancelFlights() {
        return CancelFlights.getCancelFlights();
    }

    public static List<Flight> getCloseFlights() {
        return CloseFlights.getCloseFlights();
    }

    public static List<Flight> getProgressFlights() {
        return ProgressFlights.getProgressFlights();
    }

}
