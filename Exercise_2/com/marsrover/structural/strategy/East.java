package com.marsrover.structural.strategy;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;

/**
 * East direction strategy implementation
 */
public class East implements Direction {
    @Override
    public Direction turnLeft() {
        return new North();
    }
    
    @Override
    public Direction turnRight() {
        return new South();
    }
    
    @Override
    public Position moveForward(Position position) throws InvalidPositionException {
        return position.move(1, 0);
    }
    
    @Override
    public String getName() {
        return "East";
    }
    
    @Override
    public String getSymbol() {
        return "E";
    }
}