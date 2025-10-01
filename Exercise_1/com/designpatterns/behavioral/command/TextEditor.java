package com.designpatterns.behavioral.command;

/**
 * Receiver - Single Responsibility Principle
 * Handles the actual text editing operations
 */
public class TextEditor {
    private StringBuilder content;
    
    public TextEditor() {
        this.content = new StringBuilder();
    }
    
    public void write(String text) {
        content.append(text);
    }
    
    public void delete(int length) {
        if (length > content.length()) {
            content.setLength(0);
        } else {
            content.setLength(content.length() - length);
        }
    }
    
    public String getContent() {
        return content.toString();
    }
    
    public void clear() {
        content.setLength(0);
    }
    
    public int getContentLength() {
        return content.length();
    }
}