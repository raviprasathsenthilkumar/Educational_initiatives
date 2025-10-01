package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Leaf - File (cannot contain other components)
 * Represents individual files in the file system
 */
public class File implements FileSystemComponent {
    private String name;
    private long size;
    private String fileType;
    
    public File(String name, long size, String fileType) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        if (size < 0) {
            throw new IllegalArgumentException("File size cannot be negative");
        }
        this.name = name;
        this.size = size;
        this.fileType = fileType != null ? fileType : "UNKNOWN";
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        return size;
    }
    
    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 " + name + " (" + fileType + ", " + formatSize(size) + ")");
    }
    
    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to a file");
    }
    
    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a file");
    }
    
    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>();
    }
    
    @Override
    public boolean isComposite() {
        return false;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
}