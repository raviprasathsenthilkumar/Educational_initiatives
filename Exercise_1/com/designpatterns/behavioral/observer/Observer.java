package com.designpatterns.behavioral.observer;

/**
 * Observer Interface - Interface Segregation Principle
 * Defines the contract for objects that observe subjects
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}