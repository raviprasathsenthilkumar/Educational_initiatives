package com.marsrover.exception;

/**
 * Exception thrown when an invalid direction is provided
 */
public class InvalidDirectionException extends RoverException {
    public InvalidDirectionException(String message) {
        super(message);
    }
}