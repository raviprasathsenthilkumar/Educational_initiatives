package com.designpatterns.structural.composite;

import java.util.List;

public interface FileSystemComponent {
    String getName();
    long getSize();
    void display(String indent);
    void add(FileSystemComponent component);
    void remove(FileSystemComponent component);
    List<FileSystemComponent> getChildren();
    boolean isComposite();  // Make sure this is here
}