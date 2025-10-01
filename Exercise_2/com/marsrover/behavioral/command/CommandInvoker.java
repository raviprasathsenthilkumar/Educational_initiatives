package com.marsrover.behavioral.command;

import com.marsrover.model.Rover;
import com.marsrover.model.Position;
import com.marsrover.structural.strategy.Direction;
import com.marsrover.exception.ObstacleDetectedException;
import com.marsrover.exception.RoverException;
import com.marsrover.util.RoverLogger;
import java.util.ArrayList;
import java.util.List;

/**
 * Invoker class that executes commands on the rover
 */
public class CommandInvoker {
    private final Rover rover;
    private final List<Command> commandHistory;
    private final RoverLogger logger;
    
    public CommandInvoker(Rover rover) {
        this.rover = rover;
        this.commandHistory = new ArrayList<>();
        this.logger = RoverLogger.getInstance();
    }
    
    public boolean executeCommand(Command command) {
        try {
            logger.info("Executing: " + command.getDescription());
            command.execute(rover);
            
            Position pos = rover.getPosition();
            Direction dir = rover.getDirection();
            System.out.printf("  %-15s → Position: %s, Direction: %s%n",
                command.getDescription(), pos, dir.getSymbol());
            
            commandHistory.add(command);
            return true;
        } catch (ObstacleDetectedException e) {
            logger.error("Command failed: " + e.getMessage());
            return false;
        } catch (RoverException e) {
            logger.error("Command failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void executeCommands(List<Command> commands) {
        System.out.println("\nCommand Execution Trace:");
        System.out.printf("  %-15s    Result%n", "Command");
        System.out.printf("  %-15s    %s%n", "---------------", "----------------------------------------");
        
        Position initialPos = rover.getPosition();
        Direction initialDir = rover.getDirection();
        System.out.printf("  %-15s → Position: %s, Direction: %s%n",
            "Initial", initialPos, initialDir.getSymbol());
        
        for (Command command : commands) {
            if (!executeCommand(command)) {
                logger.info("Command sequence stopped due to obstacle");
                break;
            }
        }
    }
    
    public List<Command> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
    
    public Rover getRover() {
        return rover;
    }
}