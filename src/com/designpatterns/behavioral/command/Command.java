package com.designpatterns.behavioral.command;

/**
 * Command Interface - Dependency Inversion Principle
 * Defines the contract for all command objects
 */
public interface Command {
    void execute();
    void undo();
}