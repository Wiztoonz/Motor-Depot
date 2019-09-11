package com.motordeport.controllers.listeners;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MotorDepotListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(MotorDepotListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        log.info("MotorDepot started.");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MotorDepot stopped.");
    }

}
