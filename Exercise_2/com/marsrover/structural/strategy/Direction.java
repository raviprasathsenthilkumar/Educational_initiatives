package com.marsrover.structural.strategy;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;

/**
 * Strategy interface for direction behavior
 */
public interface Direction {
    Direction turnLeft();
    Direction turnRight();
    Position moveForward(Position position) throws InvalidPositionException;
    String getName();
    String getSymbol();
}

