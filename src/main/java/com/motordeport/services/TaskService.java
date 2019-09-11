package com.motordeport.services;

import com.motordeport.dao.DbUtil;
import com.motordeport.models.flight.Flight;
import com.motordeport.models.taskModel.Progress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskService {

    private static final String SELECT_IN_PROGRESS_USERS = "SELECT First_name, Second_name, Status FROM Flights, Users WHERE Users.Id = Flights.Flight_number AND Flights.Status = 'In progress'";

    public List<Progress> usersInProgress() throws SQLException {
        CopyOnWriteArrayList<Progress> inProgress = new CopyOnWriteArrayList<>();

        Connection connection = DbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IN_PROGRESS_USERS);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Progress progress = new Progress();
            progress.setFirstName(rs.getString(1));
            progress.setSecondName(rs.getString(2));
            progress.setDescription(rs.getString(3));
            inProgress.add(progress);
        }

        return inProgress;
    }

}
