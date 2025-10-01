package com.marsrover.structural.composite;

import com.marsrover.model.Position;

/**
 * Component interface for Composite pattern
 */
public interface GridComponent {
    boolean isPassable(Position position);
}