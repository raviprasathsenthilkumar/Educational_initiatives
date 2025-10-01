package com.marsrover.model;

import com.marsrover.exception.InvalidPositionException;
import java.util.Objects;

/**
 * Immutable value object representing a position on the grid
 */
public final class Position {
    private final int x;
    private final int y;
    
    public Position(int x, int y) throws InvalidPositionException {
        if (x < 0 || y < 0) {
            throw new InvalidPositionException(
                String.format("Position coordinates cannot be negative: (%d, %d)", x, y)
            );
        }
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    /**
     * Create a new position with the given offset
     */
    public Position move(int dx, int dy) throws InvalidPositionException {
        return new Position(x + dx, y + dy);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}