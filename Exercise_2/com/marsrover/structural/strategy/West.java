package com.marsrover.structural.strategy;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;

/**
 * West direction strategy implementation
 */
public class West implements Direction {
    @Override
    public Direction turnLeft() {
        return new South();
    }
    
    @Override
    public Direction turnRight() {
        return new North();
    }
    
    @Override
    public Position moveForward(Position position) throws InvalidPositionException {
        return position.move(-1, 0);
    }
    
    @Override
    public String getName() {
        return "West";
    }
    
    @Override
    public String getSymbol() {
        return "W";
    }
}