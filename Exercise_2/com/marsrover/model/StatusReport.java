package com.marsrover.model;

import com.marsrover.structural.strategy.Direction;

/**
 * Value object representing the rover's status report
 */
public class StatusReport {
    private final Position position;
    private final Direction direction;
    private final boolean obstacleDetected;
    
    public StatusReport(Position position, Direction direction, boolean obstacleDetected) {
        this.position = position;
        this.direction = direction;
        this.obstacleDetected = obstacleDetected;
    }
    
    public String getFormattedReport() {
        String obstacleStatus = obstacleDetected 
            ? "Obstacle detected in last move." 
            : "No obstacles detected.";
        return String.format("Rover is at %s facing %s. %s",
            position, direction.getName(), obstacleStatus);
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public boolean isObstacleDetected() {
        return obstacleDetected;
    }
}