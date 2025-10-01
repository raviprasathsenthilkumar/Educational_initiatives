package com.designpatterns.creational.factory;

/**
 * Concrete Product - Rectangle
 */
public class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("  ▭ Drawing a Rectangle with width: " + width + " and height: " + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public String getShapeType() {
        return "Rectangle";
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
}