package com.marsrover.structural.strategy;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;

/**
 * North direction strategy implementation
 */
public class North implements Direction {
    @Override
    public Direction turnLeft() {
        return new West();
    }
    
    @Override
    public Direction turnRight() {
        return new East();
    }
    
    @Override
    public Position moveForward(Position position) throws InvalidPositionException {
        return position.move(0, 1);
    }
    
    @Override
    public String getName() {
        return "North";
    }
    
    @Override
    public String getSymbol() {
        return "N";
    }
}