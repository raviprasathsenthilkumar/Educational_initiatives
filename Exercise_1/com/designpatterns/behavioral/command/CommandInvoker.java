package com.designpatterns.behavioral.command;

import java.util.Stack;

/**
 * Invoker - Manages command execution and history
 * Supports undo functionality through command history
 */
public class CommandInvoker {
    private Stack<Command> commandHistory;
    private Stack<Command> redoStack;
    
    public CommandInvoker() {
        this.commandHistory = new Stack<>();
        this.redoStack = new Stack<>();
    }
    
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        redoStack.clear(); // Clear redo stack on new command
    }
    
    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("  [Nothing to undo]");
        }
    }
    
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("  [Nothing to redo]");
        }
    }
    
    public boolean canUndo() {
        return !commandHistory.isEmpty();
    }
    
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
    
    public void clearHistory() {
        commandHistory.clear();
        redoStack.clear();
    }
}