package com.marsrover.behavioral.command;

import com.marsrover.model.Rover;
import com.marsrover.exception.RoverException;

/**
 * Concrete command to move rover forward
 */
public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) throws RoverException {
        rover.moveForward();
    }
    
    @Override
    public String getDescription() {
        return "Move forward";
    }
}