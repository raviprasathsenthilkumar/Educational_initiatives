package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite - Folder (can contain other components)
 * Represents directories that can contain files and other folders
 */
public class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;
    
    public Folder(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Folder name cannot be null or empty");
        }
        this.name = name;
        this.children = new ArrayList<>();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }
    
    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name + " (" + formatSize(getSize()) + ")");
        for (FileSystemComponent child : children) {
            child.display(indent + "  ");
        }
    }
    
    @Override
    public void add(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Cannot add null component");
        }
        if (component == this) {
            throw new IllegalArgumentException("Cannot add folder to itself");
        }
        children.add(component);
    }
    
    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }
    
    @Override
    public List<FileSystemComponent> getChildren() {
        return new ArrayList<>(children);
    }
    
    @Override
    public boolean isComposite() {
        return true;
    }
    
    public int getFileCount() {
        int count = 0;
        for (FileSystemComponent child : children) {
            if (!child.isComposite()) {
                count++;
            } else if (child instanceof Folder) {
                count += ((Folder) child).getFileCount();
            }
        }
        return count;
    }
    
    public int getFolderCount() {
        int count = 0;
        for (FileSystemComponent child : children) {
            if (child.isComposite()) {
                count++;
                if (child instanceof Folder) {
                    count += ((Folder) child).getFolderCount();
                }
            }
        }
        return count;
    }
    
    public int getDirectChildrenCount() {
        return children.size();
    }
    
    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
}