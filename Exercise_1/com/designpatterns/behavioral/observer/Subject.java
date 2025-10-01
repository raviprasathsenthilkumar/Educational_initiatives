package com.designpatterns.behavioral.observer;

/**
 * Subject Interface - Dependency Inversion Principle
 * Defines the contract for observable objects
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}