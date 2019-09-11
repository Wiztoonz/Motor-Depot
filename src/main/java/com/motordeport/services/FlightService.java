package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.flight.Flight;
import com.motordeport.services.flights.CancelFlights;
import com.motordeport.services.flights.OpenFlights;
import com.motordeport.services.flights.SortFlights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private static final String INSERT_FLIGHT = "INSERT INTO Flights (Car_id, User_id, Description, Creation_date, Status) VALUES (?,?,?,?,?)";
    private static final String SELECT_FLIGHT = "SELECT * FROM Flights";
    private static final String EDIT_FLIGHT = "UPDATE Flights SET User_id = ? WHERE Flight_number = ?";
    private static final String EDIT_USER_FLIGHT = "UPDATE Flights SET Status = ? WHERE Flight_number = ?";

    public void createFlight(Flight flight) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FLIGHT);
        preparedStatement.setInt(1, flight.getCarId());
        preparedStatement.setInt(2, flight.getUserId());
        preparedStatement.setString(3, flight.getDescription());
        preparedStatement.setDate(4, flight.getCreationDate());
        preparedStatement.setString(5, flight.getStatus());
        preparedStatement.executeUpdate();
    }

    public void editFlight(Flight flight) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_FLIGHT);
        preparedStatement.setInt(1, flight.getUserId());
        preparedStatement.setInt(2, flight.getFlightsNumber());
        preparedStatement.executeUpdate();
    }

    public void editUserFlight(Flight flight) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_FLIGHT);
        preparedStatement.setString(1, flight.getStatus());
        preparedStatement.setInt(2, flight.getFlightsNumber());
        preparedStatement.executeUpdate();
    }

    public List<Flight> selectFlight() throws SQLException {
        List<Flight> list = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FLIGHT);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {

            Flight flight = new Flight();
            flight.setFlightsNumber(rs.getInt(1));
            flight.setCarId(rs.getInt(2));
            flight.setUserId(rs.getInt(3));
            flight.setDescription(rs.getString(4));
            flight.setCreationDate(rs.getDate(5));
            flight.setStatus(rs.getString(6));
            list.add(flight);
        }
        return list;
    }

    public static List<Flight> openFlights() {
        return SortFlights.getOpenFlights();
    }

    public static List<Flight> cancelFlights() {
        return SortFlights.getCancelFlights();
    }

    public static List<Flight> closeFlights() {
        return SortFlights.getCloseFlights();
    }

    public static List<Flight> progressFlights() {
        return SortFlights.getProgressFlights();
    }


}
