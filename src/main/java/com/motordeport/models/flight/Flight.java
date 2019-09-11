package com.motordeport.models.flight;

import java.sql.Date;

public class Flight  {

    private int flightsNumber;
    private int carId;
    private int userId;
    private String description;
    private Date creationDate;
    private String status;
    private String idOfUser;

    public Flight() {
    }

    public Flight(String status, int flightsNumber) {
        this.status = status;
        this.flightsNumber = flightsNumber;
    }

    public Flight(int flightsNumber, int userId) {
        this.flightsNumber = flightsNumber;
        this.userId = userId;
    }

    public Flight(int carId,int userId, String description, Date creationDate, String status) {
        this.carId = carId;
        this.userId = userId;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getIdOfUser() {
        return idOfUser;
    }

    public void setIdOfUser(String idOfUser) {
        this.idOfUser = idOfUser;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        if (userId == 0) {
            idOfUser = "Неназначен";
        } else {
            idOfUser = String.valueOf(userId);
        }
    }

    public int getFlightsNumber() {
        return flightsNumber;
    }

    public void setFlightsNumber(int flightsNumber) {
        this.flightsNumber = flightsNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return  flightsNumber +
                "" + status +
                "" + creationDate +
                "" + description +
                "" + idOfUser +
                "" + carId;
    }

}
