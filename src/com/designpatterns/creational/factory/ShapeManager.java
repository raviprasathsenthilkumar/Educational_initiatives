package com.designpatterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Shape Manager - demonstrates usage with Dependency Inversion
 * Manages a collection of shapes
 */
public class ShapeManager {
    private ShapeFactory factory;
    private List<Shape> shapes;
    
    public ShapeManager(ShapeFactory factory) {
        this.factory = factory;
        this.shapes = new ArrayList<>();
    }
    
    public Shape createAndAddShape(String shapeType, double... dimensions) {
        try {
            Shape shape = factory.createShape(shapeType, dimensions);
            shapes.add(shape);
            return shape;
        } catch (IllegalArgumentException e) {
            System.out.println("  ❌ Error: " + e.getMessage());
            return null;
        }
    }
    
    public void displayAllShapes() {
        System.out.println("\nAll Shapes:");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1) + ". " + shapes.get(i).getShapeType());
            shapes.get(i).draw();
        }
    }
    
    public double calculateTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
    
    public double calculateTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.calculatePerimeter();
        }
        return totalPerimeter;
    }
    
    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }
    
    public int getShapeCount() {
        return shapes.size();
    }
    
    public void clearShapes() {
        shapes.clear();
    }
}