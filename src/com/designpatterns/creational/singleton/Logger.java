package com.designpatterns.creational.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static class SingletonHelper {
        private static final Logger INSTANCE = new Logger();
    }
    
    private List<String> logs;
    private DateTimeFormatter formatter;
    private LogLevel currentLogLevel;
    
    private Logger() {
        this.logs = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.currentLogLevel = LogLevel.INFO;
        log(LogLevel.INFO, "Logger initialized");
    }
    
    public static Logger getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
        log(LogLevel.INFO, "Log level changed to: " + level);
    }
    
    public LogLevel getLogLevel() {
        return currentLogLevel;
    }
    
    private void log(LogLevel level, String message) {
        if (level.getPriority() >= currentLogLevel.getPriority()) {
            String timestamp = LocalDateTime.now().format(formatter);
            String logEntry = String.format("[%s] [%s] %s", timestamp, level, message);
            logs.add(logEntry);
            System.out.println(logEntry);
        }
    }
    
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    
    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }
    
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
    
    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
    
    public void clearLogs() {
        logs.clear();
        log(LogLevel.INFO, "Logs cleared");
    }
    
    public int getLogCount() {
        return logs.size();
    }
    
    public List<String> getLogsByLevel(LogLevel level) {
        List<String> filteredLogs = new ArrayList<>();
        String levelString = "[" + level + "]";
        for (String log : logs) {
            if (log.contains(levelString)) {
                filteredLogs.add(log);
            }
        }
        return filteredLogs;
    }
}