package com.designpatterns.creational.factory;

/**
 * Concrete Product - Pentagon (Regular)
 * Demonstrates extensibility
 */
public class Pentagon implements Shape {
    private double side;
    
    public Pentagon(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.side = side;
    }
    
    @Override
    public void draw() {
        System.out.println("  ⬟ Drawing a Pentagon with side: " + side);
    }
    
    @Override
    public double calculateArea() {
        // Area = (1/4) * √(5(5+2√5)) * side²
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }
    
    @Override
    public double calculatePerimeter() {
        return 5 * side;
    }
    
    @Override
    public String getShapeType() {
        return "Pentagon";
    }
    
    public double getSide() {
        return side;
    }
}