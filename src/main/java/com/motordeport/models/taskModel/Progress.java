package com.motordeport.models.taskModel;

public class Progress {

    private String firstName;
    private String secondName;
    private String description;

    public Progress() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
