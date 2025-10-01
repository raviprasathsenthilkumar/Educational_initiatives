package com.marsrover.creational.builder;

import com.marsrover.model.Position;
import com.marsrover.model.Rover;
import com.marsrover.structural.strategy.Direction;
import com.marsrover.structural.composite.Grid;
import com.marsrover.structural.composite.Obstacle;
import com.marsrover.creational.factory.DirectionFactory;
import com.marsrover.exception.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder pattern for constructing Rover and Grid configuration
 */
public class RoverBuilder {
    private int gridWidth = 10;
    private int gridHeight = 10;
    private Grid grid;
    private Position startingPosition;
    private Direction startingDirection;
    private List<Position> obstacles = new ArrayList<>();
    
    public RoverBuilder setGridSize(int width, int height) {
        this.gridWidth = width;
        this.gridHeight = height;
        return this;
    }
    
    public RoverBuilder setStartingPosition(int x, int y) throws InvalidPositionException {
        this.startingPosition = new Position(x, y);
        return this;
    }
    
    public RoverBuilder setStartingDirection(String directionSymbol) 
            throws InvalidDirectionException {
        this.startingDirection = DirectionFactory.createDirection(directionSymbol);
        return this;
    }
    
    public RoverBuilder addObstacle(int x, int y) throws InvalidPositionException {
        this.obstacles.add(new Position(x, y));
        return this;
    }
    
    public RoverBuilder addObstacles(int[][] obstaclePositions) 
            throws InvalidPositionException {
        for (int[] pos : obstaclePositions) {
            addObstacle(pos[0], pos[1]);
        }
        return this;
    }
    
    public Rover build() throws InvalidPositionException, InvalidDirectionException {
        // Build grid
        grid = new Grid(gridWidth, gridHeight);
        
        // Add obstacles
        for (Position obstaclePos : obstacles) {
            grid.addComponent(new Obstacle(obstaclePos));
        }
        
        // Set defaults if not provided
        if (startingPosition == null) {
            startingPosition = new Position(0, 0);
        }
        
        if (startingDirection == null) {
            startingDirection = DirectionFactory.createDirection("N");
        }
        
        // Build and return rover
        return new Rover(startingPosition, startingDirection, grid);
    }
    
    public RoverBuilder reset() {
        this.gridWidth = 10;
        this.gridHeight = 10;
        this.grid = null;
        this.startingPosition = null;
        this.startingDirection = null;
        this.obstacles = new ArrayList<>();
        return this;
    }
}