package com.marsrover.behavioral.command;

import com.marsrover.model.Rover;

/**
 * Concrete command to turn rover right
 */
public class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
    
    @Override
    public String getDescription() {
        return "Turn right";
    }
}

