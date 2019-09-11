package com.motordeport.models.request;

import java.sql.Date;

public class Request {

    private int id;
    private int flightNumber;
    private String carCharacteristics;
    private Date creationDate;
    private int userId;

    public Request() {
    }

    public Request(int flightNumber, String carCharacteristics, Date creationDate, int userId) {
        this.flightNumber = flightNumber;
        this.carCharacteristics = carCharacteristics;
        this.creationDate = creationDate;
        this.userId = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCarCharacteristics() {
        return carCharacteristics;
    }

    public void setCarCharacteristics(String carCharacteristics) {
        this.carCharacteristics = carCharacteristics;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return  id +
                "" + flightNumber +
                "" + carCharacteristics +
                "" + creationDate +
                "" + userId;
    }
}
