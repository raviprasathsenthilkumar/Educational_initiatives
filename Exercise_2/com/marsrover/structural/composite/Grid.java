package com.marsrover.structural.composite;

import com.marsrover.model.Position;
import com.marsrover.exception.InvalidPositionException;
import com.marsrover.util.RoverLogger;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite component representing the terrain grid
 */
public class Grid implements GridComponent {
    private final int width;
    private final int height;
    private final List<GridComponent> components;
    private final RoverLogger logger;
    
    public Grid(int width, int height) throws InvalidPositionException {
        if (width <= 0 || height <= 0) {
            throw new InvalidPositionException("Grid dimensions must be positive");
        }
        this.width = width;
        this.height = height;
        this.components = new ArrayList<>();
        this.logger = RoverLogger.getInstance();
        logger.info(String.format("Grid created with dimensions %dx%d", width, height));
    }
    
    public void addComponent(GridComponent component) {
        components.add(component);
    }
    
    public void removeComponent(GridComponent component) {
        components.remove(component);
    }
    
    @Override
    public boolean isPassable(Position position) {
        return components.stream().allMatch(c -> c.isPassable(position));
    }
    
    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public List<GridComponent> getComponents() {
        return new ArrayList<>(components);
    }
}