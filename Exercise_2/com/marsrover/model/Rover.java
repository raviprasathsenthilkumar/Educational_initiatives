package com.marsrover.model;

import com.marsrover.structural.strategy.Direction;
import com.marsrover.structural.composite.Grid;
import com.marsrover.exception.InvalidPositionException;
import com.marsrover.exception.ObstacleDetectedException;
import com.marsrover.util.RoverLogger;

/**
 * Mars Rover entity with navigation capabilities
 */
public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;
    private boolean obstacleDetected;
    private final RoverLogger logger;
    
    public Rover(Position position, Direction direction, Grid grid) 
            throws InvalidPositionException {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.obstacleDetected = false;
        this.logger = RoverLogger.getInstance();
        
        validatePosition(position, "Starting");
        
        logger.info(String.format("Rover initialized at %s facing %s",
            position, direction.getName()));
    }
    
    private void validatePosition(Position position, String context) 
            throws InvalidPositionException {
        if (!grid.isWithinBounds(position)) {
            throw new InvalidPositionException(
                String.format("%s position %s is outside grid boundaries", context, position)
            );
        }
        
        if (!grid.isPassable(position)) {
            throw new InvalidPositionException(
                String.format("%s position %s contains an obstacle", context, position)
            );
        }
    }
    
    public void moveForward() throws InvalidPositionException, ObstacleDetectedException {
        Position newPosition = direction.moveForward(position);
        
        if (!grid.isWithinBounds(newPosition)) {
            logger.warning("Cannot move to " + newPosition + ": Outside grid boundaries");
            throw new InvalidPositionException(
                "Position " + newPosition + " is outside grid boundaries"
            );
        }
        
        if (!grid.isPassable(newPosition)) {
            obstacleDetected = true;
            logger.warning("Obstacle detected at " + newPosition + ". Rover stopped.");
            throw new ObstacleDetectedException("Obstacle detected at " + newPosition);
        }
        
        position = newPosition;
        obstacleDetected = false;
        logger.info("Rover moved to " + position);
    }
    
    public void turnLeft() {
        String oldDirection = direction.getName();
        direction = direction.turnLeft();
        logger.info(String.format("Rover turned left from %s to %s",
            oldDirection, direction.getName()));
    }
    
    public void turnRight() {
        String oldDirection = direction.getName();
        direction = direction.turnRight();
        logger.info(String.format("Rover turned right from %s to %s",
            oldDirection, direction.getName()));
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public boolean wasObstacleDetected() {
        return obstacleDetected;
    }
    
    public StatusReport getStatusReport() {
        return new StatusReport(position, direction, obstacleDetected);
    }
    
    public Grid getGrid() {
        return grid;
    }
}