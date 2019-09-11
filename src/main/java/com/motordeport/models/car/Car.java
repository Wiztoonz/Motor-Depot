package com.motordeport.models.car;

public class Car {

    private int id;
    private String car;
    private String carStatus;
    private String description;


    public Car() {
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(int id, String description, String car, String carStatus) {
        this.id = id;
        this.description = description;
        this.car = car;
        this.carStatus = carStatus;
    }

    public Car(String car, String carStatus, String description) {
        this.car = car;
        this.carStatus = carStatus;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car='" + car + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
