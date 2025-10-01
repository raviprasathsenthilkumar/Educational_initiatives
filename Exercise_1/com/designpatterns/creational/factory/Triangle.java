package com.designpatterns.creational.factory;

/**
 * Concrete Product - Triangle
 */
public class Triangle implements Shape {
    private double base;
    private double height;
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
        this.base = base;
        this.height = height;
        // Calculate sides assuming right triangle for perimeter
        this.sideA = base;
        this.sideB = height;
        this.sideC = Math.sqrt(base * base + height * height);
    }
    
    @Override
    public void draw() {
        System.out.println("  🔺 Drawing a Triangle with base: " + base + " and height: " + height);
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public String getShapeType() {
        return "Triangle";
    }
    
    public double getBase() {
        return base;
    }
    
    public double getHeight() {
        return height;
    }
}