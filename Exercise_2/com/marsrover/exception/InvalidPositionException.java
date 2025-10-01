package com.marsrover.exception;

/**
 * Exception thrown when a position is invalid or out of bounds
 */
public class InvalidPositionException extends RoverException {
    public InvalidPositionException(String message) {
        super(message);
    }
}