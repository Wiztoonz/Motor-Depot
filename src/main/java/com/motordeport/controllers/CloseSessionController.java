package com.motordeport.controllers;

import com.motordeport.Paths;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class CloseSessionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String sessionName = attributeNames.nextElement();
            if (sessionName.equals("Driver")) {
                session.invalidate();
            }
            if (sessionName.equals("Admin")) {
                session.invalidate();
            }
            if (sessionName.equals("Dispatcher")) {
                session.invalidate();
            }
        }

        resp.sendRedirect(Paths.MAIN_PAGE);

    }
}
