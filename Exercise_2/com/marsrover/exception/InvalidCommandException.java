package com.marsrover.exception;

/**
 * Exception thrown when an invalid command is provided
 */
public class InvalidCommandException extends RoverException {
    public InvalidCommandException(String message) {
        super(message);
    }
}