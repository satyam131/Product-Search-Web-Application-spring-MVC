package com.nagarro.javaAdvance.assignment4.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * This class implements ServletContextListener which can be used to listen for events in an application
 * Initializes ModificationWatcher thread when web app starts up and destroying it when shuts down
 * @author aryanverma
 *
 */
@WebListener
public class InitThreadSchedulers implements ServletContextListener {
	/**
	 * When web app shuts down it prints a message that server destroyed
	 */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("server destroyed");
    }

    @Override
    /**
     * When web app starts it creates scheduleExecutorService using Executor.newSingleThreadScheduledExecutor() method
     * which creates a pool with single thread and schedule tasks to be run periodically or at specific time
     */
    public void contextInitialized(ServletContextEvent arg0) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);
    }

}
