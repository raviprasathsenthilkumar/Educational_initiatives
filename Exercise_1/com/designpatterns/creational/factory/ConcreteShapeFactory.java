package com.designpatterns.creational.factory;

/**
 * Concrete Factory - Implements the factory method
 * Open/Closed: Can be extended without modifying existing code
 */
public class ConcreteShapeFactory implements ShapeFactory {
    
    @Override
    public Shape createShape(String shapeType, double... dimensions) {
        if (shapeType == null || shapeType.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape type cannot be null or empty");
        }
        
        // Normalize input
        shapeType = shapeType.trim().toUpperCase();
        
        // Factory method decides which concrete class to instantiate
        switch (shapeType) {
            case "CIRCLE":
                validateDimensions(shapeType, dimensions, 1);
                return new Circle(dimensions[0]);
                
            case "SQUARE":
                validateDimensions(shapeType, dimensions, 1);
                return new Square(dimensions[0]);
                
            case "TRIANGLE":
                validateDimensions(shapeType, dimensions, 2);
                return new Triangle(dimensions[0], dimensions[1]);
                
            case "RECTANGLE":
                validateDimensions(shapeType, dimensions, 2);
                return new Rectangle(dimensions[0], dimensions[1]);
                
            case "PENTAGON":
                validateDimensions(shapeType, dimensions, 1);
                return new Pentagon(dimensions[0]);
                
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType + 
                    ". Supported types: CIRCLE, SQUARE, TRIANGLE, RECTANGLE, PENTAGON");
        }
    }
    
    private void validateDimensions(String shapeType, double[] dimensions, int required) {
        if (dimensions == null || dimensions.length < required) {
            throw new IllegalArgumentException(shapeType + " requires " + required + " dimension(s)");
        }
    }
}