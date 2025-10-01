package com.marsrover.creational.factory;

import com.marsrover.behavioral.command.*;
import com.marsrover.exception.InvalidCommandException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Factory for creating Command objects
 */
public class CommandFactory {
    private static final Map<String, Class<? extends Command>> commandMap = new HashMap<>();
    
    static {
        commandMap.put("M", MoveCommand.class);
        commandMap.put("L", TurnLeftCommand.class);
        commandMap.put("R", TurnRightCommand.class);
    }
    
    public static Command createCommand(String symbol) throws InvalidCommandException {
        Class<? extends Command> commandClass = commandMap.get(symbol.toUpperCase());
        if (commandClass == null) {
            throw new InvalidCommandException("Invalid command symbol: " + symbol);
        }
        
        try {
            return commandClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new InvalidCommandException("Failed to create command: " + symbol);
        }
    }
    
    public static List<Command> createCommands(String[] symbols) throws InvalidCommandException {
        List<Command> commands = new ArrayList<>();
        for (String symbol : symbols) {
            commands.add(createCommand(symbol));
        }
        return commands;
    }
    
    public static Set<String> getAvailableCommands() {
        return commandMap.keySet();
    }
}