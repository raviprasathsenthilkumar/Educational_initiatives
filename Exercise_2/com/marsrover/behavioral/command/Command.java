package com.marsrover.behavioral.command;

import com.marsrover.model.Rover;
import com.marsrover.exception.RoverException;

/**
 * Command interface for Command pattern
 */
public interface Command {
    void execute(Rover rover) throws RoverException;
    String getDescription();
}