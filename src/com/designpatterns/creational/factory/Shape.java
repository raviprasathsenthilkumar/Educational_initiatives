package com.designpatterns.creational.factory;

public interface Shape {
    void draw();
    double calculateArea();
    double calculatePerimeter();  // Make sure this is here
    String getShapeType();
}