package com.designpatterns.creational.factory;

/**
 * Concrete Product - Circle
 */
public class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("  🔵 Drawing a Circle with radius: " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String getShapeType() {
        return "Circle";
    }
    
    public double getRadius() {
        return radius;
    }
}