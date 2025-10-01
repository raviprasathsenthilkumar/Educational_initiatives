package com.marsrover.structural.composite;

import com.marsrover.model.Position;
import com.marsrover.util.RoverLogger;

/**
 * Leaf component representing an obstacle
 */
public class Obstacle implements GridComponent {
    private final Position position;
    private final RoverLogger logger;
    
    public Obstacle(Position position) {
        this.position = position;
        this.logger = RoverLogger.getInstance();
        logger.info("Obstacle created at " + position);
    }
    
    @Override
    public boolean isPassable(Position position) {
        return !this.position.equals(position);
    }
    
    public Position getPosition() {
        return position;
    }
}