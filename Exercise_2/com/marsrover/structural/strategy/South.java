package com.marsrover.structural.strategy;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;

/**
 * South direction strategy implementation
 */
public class South implements Direction {
    @Override
    public Direction turnLeft() {
        return new East();
    }
    
    @Override
    public Direction turnRight() {
        return new West();
    }
    
    @Override
    public Position moveForward(Position position) throws InvalidPositionException {
        return position.move(0, -1);
    }
    
    @Override
    public String getName() {
        return "South";
    }
    
    @Override
    public String getSymbol() {
        return "S";
    }
}

