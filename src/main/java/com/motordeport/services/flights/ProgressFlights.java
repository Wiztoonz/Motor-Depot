package com.motordeport.services.flights;

import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgressFlights {

    public static List<Flight> getProgressFlights() {
        FlightService flightService = new FlightService();
        List<Flight> progressList = new ArrayList<>();
        try {
            List<Flight> flightList = flightService.selectFlight();
            for (Flight flight : flightList) {
                if (flight.getStatus().equalsIgnoreCase("In progress")) {
                    progressList.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progressList;
    }

}
