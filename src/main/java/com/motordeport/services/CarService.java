package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.car.Car;
import com.motordeport.services.cars.SortCars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CarService {

    private static final String INSERT_CAR = "INSERT INTO Cars (Car, Car_status, Description) VALUES (?,?,?)";
    private static final String EDIT_CAR = "UPDATE Cars SET Description = ?, Car = ?, Car_status = ? WHERE id = ?";
    private static final String DELETE_CAR = "DELETE FROM Cars WHERE id = ?";
    private static final String SELECT_CAR = "SELECT * FROM Cars";

    public void createCar(Car car) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR);
        preparedStatement.setString(1, car.getCar());
        preparedStatement.setString(2, car.getCarStatus());
        preparedStatement.setString(3, car.getDescription());
        preparedStatement.executeUpdate();
    }

    public List<Car> selectCar() throws SQLException {
        List<Car> list = new CopyOnWriteArrayList<>();
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CAR);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getInt(1));
            car.setCar(rs.getString(2));
            car.setCarStatus(rs.getString(3));
            car.setDescription(rs.getString(4));
            list.add(car);
        }
        return list;
    }

    public void editCar(Car car) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_CAR);
        preparedStatement.setString(1, car.getDescription());
        preparedStatement.setString(2, car.getCar());
        preparedStatement.setString(3, car.getCarStatus());
        preparedStatement.setInt(4, car.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteCar(Car car) throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR);
        preparedStatement.setInt(1, car.getId());
        preparedStatement.executeUpdate();
    }

    public static List<Car> bCars() {
        return SortCars.getBCars();
    }

    public static List<Car> beCars() {
        return SortCars.getBECars();
    }

    public static List<Car> cCars() {
        return SortCars.getCCars();
    }

    public static List<Car> ceCars() {
        return SortCars.getCECars();
    }

}
