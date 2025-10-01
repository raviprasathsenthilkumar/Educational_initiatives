package com.marsrover.creational.factory;

import com.marsrover.structural.strategy.*;
import com.marsrover.exception.InvalidDirectionException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Factory for creating Direction objects
 */
public class DirectionFactory {
    private static final Map<String, Class<? extends Direction>> directionMap = new HashMap<>();
    
    static {
        directionMap.put("N", North.class);
        directionMap.put("S", South.class);
        directionMap.put("E", East.class);
        directionMap.put("W", West.class);
    }
    
    public static Direction createDirection(String symbol) throws InvalidDirectionException {
        Class<? extends Direction> directionClass = directionMap.get(symbol.toUpperCase());
        if (directionClass == null) {
            throw new InvalidDirectionException("Invalid direction symbol: " + symbol);
        }
        
        try {
            return directionClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new InvalidDirectionException("Failed to create direction: " + symbol);
        }
    }
    
    public static Set<String> getAvailableDirections() {
        return directionMap.keySet();
    }
}