package com.motordeport.services.flights;

import com.motordeport.models.flight.Flight;
import com.motordeport.services.FlightService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CloseFlights {

    public static List<Flight> getCloseFlights() {
        FlightService flightService = new FlightService();
        List<Flight> closeList = new ArrayList<>();
        try {
            List<Flight> flightList = flightService.selectFlight();
            for (Flight flight : flightList) {
                if (flight.getStatus().equalsIgnoreCase("Is closed")) {
                    closeList.add(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return closeList;
    }

}
