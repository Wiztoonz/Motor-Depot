package com.motordeport.controllers;

import com.motordeport.Paths;
import com.motordeport.services.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SortCECarsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("Admin") != null) {
            session.setAttribute("ListCars", CarService.ceCars());
            String forwardPath = String.valueOf(req.getAttribute("forwardPath"));
            req.getRequestDispatcher(forwardPath).forward(req,resp);
        }

        if (session.getAttribute("Dispatcher") != null) {
            session.setAttribute("ListCars", CarService.ceCars());
            String forwardPath = String.valueOf(req.getAttribute("forwardPath"));
            req.getRequestDispatcher(forwardPath).forward(req,resp);
        }

        if (session.getAttribute("Admin") == null && session.getAttribute("Dispatcher") == null) {
            resp.sendRedirect(Paths.LOGIN_NO_SESSION);
        }

    }

}
