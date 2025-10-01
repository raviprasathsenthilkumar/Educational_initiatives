package com.designpatterns.creational.factory;

/**
 * Factory Interface - Open/Closed Principle
 * Defines the contract for shape factories
 */
public interface ShapeFactory {
    Shape createShape(String shapeType, double... dimensions);
}