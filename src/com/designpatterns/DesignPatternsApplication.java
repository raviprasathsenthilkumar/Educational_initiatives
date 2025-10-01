package com.designpatterns;

import com.designpatterns.behavioral.command.*;
import com.designpatterns.behavioral.observer.*;
import com.designpatterns.creational.singleton.Logger;
import com.designpatterns.creational.singleton.LogLevel;
import com.designpatterns.creational.factory.*;
import com.designpatterns.structural.adapter.*;
import com.designpatterns.structural.composite.*;

/**
 * Main Application demonstrating all six design patterns
 * Follows Single Responsibility Principle - coordinates pattern demonstrations
 */
public class DesignPatternsApplication {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("DESIGN PATTERNS DEMONSTRATION APPLICATION");
        System.out.println("=".repeat(80));
        
        demonstrateBehavioralPatterns();
        demonstrateCreationalPatterns();
        demonstrateStructuralPatterns();
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL DEMONSTRATIONS COMPLETED SUCCESSFULLY");
        System.out.println("=".repeat(80));
    }
    
    private static void demonstrateBehavioralPatterns() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("BEHAVIORAL PATTERNS");
        System.out.println("=".repeat(80));
        
        // Command Pattern Demonstration
        System.out.println("\n--- COMMAND PATTERN: Text Editor ---");
        demonstrateCommandPattern();
        
        // Observer Pattern Demonstration
        System.out.println("\n--- OBSERVER PATTERN: Weather Station ---");
        demonstrateObserverPattern();
    }
    
    private static void demonstrateCreationalPatterns() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("CREATIONAL PATTERNS");
        System.out.println("=".repeat(80));
        
        // Singleton Pattern Demonstration
        System.out.println("\n--- SINGLETON PATTERN: Logger ---");
        demonstrateSingletonPattern();
        
        // Factory Pattern Demonstration
        System.out.println("\n--- FACTORY METHOD PATTERN: Shape Factory ---");
        demonstrateFactoryPattern();
    }
    
    private static void demonstrateStructuralPatterns() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("STRUCTURAL PATTERNS");
        System.out.println("=".repeat(80));
        
        // Adapter Pattern Demonstration
        System.out.println("\n--- ADAPTER PATTERN: Media Player ---");
        demonstrateAdapterPattern();
        
        // Composite Pattern Demonstration
        System.out.println("\n--- COMPOSITE PATTERN: File System ---");
        demonstrateCompositePattern();
    }
    
    private static void demonstrateCommandPattern() {
        TextEditor editor = new TextEditor();
        CommandInvoker invoker = new CommandInvoker();
        
        System.out.println("Initial content: '" + editor.getContent() + "'");
        
        Command writeHello = new WriteCommand(editor, "Hello ");
        invoker.executeCommand(writeHello);
        System.out.println("Content: '" + editor.getContent() + "'");
        
        Command writeWorld = new WriteCommand(editor, "World!");
        invoker.executeCommand(writeWorld);
        System.out.println("Content: '" + editor.getContent() + "'");
        
        CopyCommand copyCmd = new CopyCommand(editor, "World!");
        invoker.executeCommand(copyCmd);
        
        Command pasteCmd = new PasteCommand(editor, copyCmd.getClipboard());
        invoker.executeCommand(pasteCmd);
        System.out.println("Content: '" + editor.getContent() + "'");
        
        System.out.println("\nPerforming Undo:");
        invoker.undo();
        System.out.println("Content: '" + editor.getContent() + "'");
    }
    
    private static void demonstrateObserverPattern() {
        WeatherStation weatherStation = new WeatherStation();
        
        PhoneAppDisplay phoneDisplay = new PhoneAppDisplay(weatherStation);
        WebDashboardDisplay webDisplay = new WebDashboardDisplay(weatherStation);
        LEDScreenDisplay ledDisplay = new LEDScreenDisplay(weatherStation);
        StatisticsDisplay statsDisplay = new StatisticsDisplay(weatherStation);
        
        weatherStation.setMeasurements(25.5f, 65.0f, 1013.1f);
        weatherStation.setMeasurements(27.2f, 70.0f, 1012.5f);
        
        System.out.println("\n[Detaching LED Display]");
        weatherStation.detach(ledDisplay);
        
        weatherStation.setMeasurements(23.8f, 68.0f, 1014.0f);
    }
    
    private static void demonstrateSingletonPattern() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Logger instances are same: " + (logger1 == logger2));
        System.out.println("Hash codes - logger1: " + System.identityHashCode(logger1) + 
                         ", logger2: " + System.identityHashCode(logger2));
        
        logger1.setLogLevel(LogLevel.INFO);
        logger1.info("Application started");
        logger1.warning("This is a warning message");
        logger1.error("This is an error message");
        
        System.out.println("\nTotal logs recorded: " + logger1.getLogCount());
    }
    
    private static void demonstrateFactoryPattern() {
        ShapeFactory factory = new ConcreteShapeFactory();
        
        try {
            Shape circle = factory.createShape("circle", 5.0);
            circle.draw();
            System.out.println("Area: " + String.format("%.2f", circle.calculateArea()));
            
            Shape square = factory.createShape("square", 4.0);
            square.draw();
            System.out.println("Area: " + String.format("%.2f", square.calculateArea()));
            
            Shape triangle = factory.createShape("triangle", 6.0, 8.0);
            triangle.draw();
            System.out.println("Area: " + String.format("%.2f", triangle.calculateArea()));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateAdapterPattern() {
        MediaPlayer audioPlayer = new AudioPlayer();
        
        System.out.println("Playing MP3 (native support):");
        audioPlayer.play("mp3", "song.mp3");
        
        System.out.println("\nPlaying MP4 (via adapter):");
        audioPlayer.play("mp4", "movie.mp4");
        
        System.out.println("\nPlaying VLC (via adapter):");
        audioPlayer.play("vlc", "video.vlc");
        
        System.out.println("\nAttempting unsupported format:");
        audioPlayer.play("avi", "oldmovie.avi");
    }
    
    private static void demonstrateCompositePattern() {
        Folder root = new Folder("Root");
        
        Folder documents = new Folder("Documents");
        documents.add(new File("resume.pdf", 524288, "PDF"));
        documents.add(new File("cover_letter.docx", 102400, "DOCX"));
        
        Folder work = new Folder("Work");
        work.add(new File("project_plan.xlsx", 204800, "XLSX"));
        work.add(new File("meeting_notes.txt", 5120, "TXT"));
        documents.add(work);
        
        Folder pictures = new Folder("Pictures");
        pictures.add(new File("vacation.jpg", 2097152, "JPG"));
        pictures.add(new File("family.png", 1572864, "PNG"));
        
        root.add(documents);
        root.add(pictures);
        root.add(new File("readme.txt", 1024, "TXT"));
        
        System.out.println("\nFile System Structure:");
        root.display("");
        
        System.out.println("\nTotal Size: " + formatSize(root.getSize()));
    }
    
    private static String formatSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.1f KB", bytes / 1024.0);
        return String.format("%.1f MB", bytes / (1024.0 * 1024.0));
    }
}