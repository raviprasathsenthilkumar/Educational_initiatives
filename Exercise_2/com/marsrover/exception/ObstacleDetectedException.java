package com.marsrover.exception;

/**
 * Exception thrown when an obstacle is detected in the rover's path
 */
public class ObstacleDetectedException extends RoverException {
    public ObstacleDetectedException(String message) {
        super(message);
    }
}