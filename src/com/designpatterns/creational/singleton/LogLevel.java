// File: com/designpatterns/creational/singleton/LogLevel.java
package com.designpatterns.creational.singleton;

/**
 * Log Level Enum - for better type safety
 */
public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);
    
    private final int priority;
    
    LogLevel(int priority) {
        this.priority = priority;
    }
    
    public int getPriority() {
        return priority;
    }
}