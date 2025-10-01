package com.designpatterns.structural.composite;

/**
 * Builder helper class for constructing file systems
 * Demonstrates fluent API design
 */
public class FileSystemBuilder {
    private Folder currentFolder;
    
    public FileSystemBuilder(String rootName) {
        this.currentFolder = new Folder(rootName);
    }
    
    public FileSystemBuilder addFile(String name, long size, String type) {
        currentFolder.add(new File(name, size, type));
        return this;
    }
    
    public FileSystemBuilder addFolder(String name) {
        Folder newFolder = new Folder(name);
        currentFolder.add(newFolder);
        return this;
    }
    
    public Folder build() {
        return currentFolder;
    }
    
    public Folder getCurrentFolder() {
        return currentFolder;
    }
}
