package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.request.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestService {


    private static final String INSERT_REQUEST = "INSERT INTO Request (Flight_number, Car_characteristics, Creation_date, User_id) VALUES (?,?,?,?)";
    private static final String SELECT_REQUEST = "SELECT * FROM Request";

    public void createRequest(Request request) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REQUEST);
        preparedStatement.setInt(1, request.getFlightNumber());
        preparedStatement.setString(2, request.getCarCharacteristics());
        preparedStatement.setDate(3, request.getCreationDate());
        preparedStatement.setInt(4, request.getUserId());
        preparedStatement.executeUpdate();
    }

    public List<Request> selectUserRequest() throws SQLException {
        List<Request> list = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REQUEST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Request request = new Request();
            request.setId(rs.getInt(1));
            request.setFlightNumber(rs.getInt(2));
            request.setCarCharacteristics(rs.getString(3));
            request.setCreationDate(rs.getDate(4));
            request.setUserId(rs.getInt(5));
            list.add(request);
        }
        return list;
    }

}
