package com.motordeport.services.flights;

import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancelFlights {

    public static List<Flight> getCancelFlights() {
        FlightService flightService = new FlightService();
        List<Flight> cancelList = new ArrayList<>();
        try {
            List<Flight> flightList = flightService.selectFlight();
            for (Flight flight : flightList) {
                if (flight.getStatus().equalsIgnoreCase("Canceled")) {
                    cancelList.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cancelList;
    }

}
