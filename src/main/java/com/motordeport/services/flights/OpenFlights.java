package com.motordeport.services.flights;

import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenFlights {

    public static List<Flight> getOpenFlights() {
        FlightService flightService = new FlightService();
        List<Flight> openList = new ArrayList<>();
        try {
            List<Flight> flightList = flightService.selectFlight();
            for (Flight flight : flightList) {
                if (flight.getStatus().equalsIgnoreCase("Open")) {
                    openList.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return openList;
    }

}
