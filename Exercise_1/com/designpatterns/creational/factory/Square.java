package com.designpatterns.creational.factory;

/**
 * Concrete Product - Square
 */
public class Square implements Shape {
    private double side;
    
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        this.side = side;
    }
    
    @Override
    public void draw() {
        System.out.println("  🟦 Drawing a Square with side: " + side);
    }
    
    @Override
    public double calculateArea() {
        return side * side;
    }
    
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
    
    @Override
    public String getShapeType() {
        return "Square";
    }
    
    public double getSide() {
        return side;
    }
}