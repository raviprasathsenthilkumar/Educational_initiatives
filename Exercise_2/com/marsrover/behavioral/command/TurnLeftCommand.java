package com.marsrover.behavioral.command;

import com.marsrover.model.Rover;

/**
 * Concrete command to turn rover left
 */
public class TurnLeftCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
    
    @Override
    public String getDescription() {
        return "Turn left";
    }
}