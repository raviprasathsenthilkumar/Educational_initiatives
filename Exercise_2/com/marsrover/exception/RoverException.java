package com.marsrover.exception;

/**
 * Base exception for all Rover-related errors
 */
public class RoverException extends Exception {
    public RoverException(String message) {
        super(message);
    }
    
    public RoverException(String message, Throwable cause) {
        super(message, cause);
    }
}