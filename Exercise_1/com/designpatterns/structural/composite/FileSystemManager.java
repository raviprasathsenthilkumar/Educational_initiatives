package com.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * File System Manager - demonstrates operations on the composite structure
 * Provides high-level operations for managing the file system
 */
public class FileSystemManager {
    private FileSystemComponent root;
    
    public FileSystemManager(FileSystemComponent root) {
        if (root == null) {
            throw new IllegalArgumentException("Root component cannot be null");
        }
        this.root = root;
    }
    
    public void displayStructure() {
        System.out.println("\nFile System Structure:");
        System.out.println("=".repeat(50));
        root.display("");
        System.out.println("=".repeat(50));
    }
    
    public void displayStatistics() {
        System.out.println("\nFile System Statistics:");
        System.out.println("Total size: " + formatSize(root.getSize()));
        
        if (root instanceof Folder) {
            Folder folder = (Folder) root;
            System.out.println("Total folders: " + (folder.getFolderCount() + 1));
            System.out.println("Total files: " + folder.getFileCount());
        }
    }
    
    public List<FileSystemComponent> search(String searchTerm) {
        List<FileSystemComponent> results = new ArrayList<>();
        searchRecursive(root, searchTerm, results);
        return results;
    }
    
    private void searchRecursive(FileSystemComponent component, String searchTerm, List<FileSystemComponent> results) {
        if (component.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
            results.add(component);
        }
        
        for (FileSystemComponent child : component.getChildren()) {
            searchRecursive(child, searchTerm, results);
        }
    }
    
    public void displaySearchResults(String searchTerm) {
        System.out.println("\nSearching for: '" + searchTerm + "'");
        List<FileSystemComponent> results = search(searchTerm);
        
        if (results.isEmpty()) {
            System.out.println("  No results found.");
        } else {
            System.out.println("  Found " + results.size() + " result(s):");
            for (FileSystemComponent component : results) {
                String type = component.isComposite() ? "Folder" : "File";
                System.out.println("  - " + type + ": " + component.getName() + " (" + formatSize(component.getSize()) + ")");
            }
        }
    }
    
    public List<FileSystemComponent> findByType(String fileType) {
        List<FileSystemComponent> results = new ArrayList<>();
        findByTypeRecursive(root, fileType, results);
        return results;
    }
    
    private void findByTypeRecursive(FileSystemComponent component, String fileType, List<FileSystemComponent> results) {
        if (component instanceof File) {
            File file = (File) component;
            if (file.getFileType().equalsIgnoreCase(fileType)) {
                results.add(file);
            }
        }
        
        for (FileSystemComponent child : component.getChildren()) {
            findByTypeRecursive(child, fileType, results);
        }
    }
    
    public long calculateTotalSize() {
        return root.getSize();
    }
    
    public FileSystemComponent getRoot() {
        return root;
    }
    
    private String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
        return String.format("%.1f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    }
}