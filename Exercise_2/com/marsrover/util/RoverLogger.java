package com.marsrover.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Singleton Logger for the Mars Rover application
 * Thread-safe implementation using Bill Pugh Singleton pattern
 */
public class RoverLogger {
    private static final DateTimeFormatter FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Bill Pugh Singleton Design Pattern
    private static class SingletonHelper {
        private static final RoverLogger INSTANCE = new RoverLogger();
    }
    
    private RoverLogger() {
        // Private constructor to prevent instantiation
    }
    
    public static RoverLogger getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void warning(String message) {
        log("WARNING", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    public void critical(String message) {
        log("CRITICAL", message);
    }
    
    private void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println(String.format("%s - MarsRover - %s - %s", 
            timestamp, level, message));
    }
}

