// ============================================================================
// FILE: com/marsrover/MarsRoverApplication.java (UPDATED WITH USER INPUT)
// ============================================================================
package com.marsrover;

import com.marsrover.creational.builder.RoverBuilder;
import com.marsrover.creational.factory.CommandFactory;
import com.marsrover.behavioral.command.Command;
import com.marsrover.behavioral.command.CommandInvoker;
import com.marsrover.model.Rover;
import com.marsrover.model.StatusReport;
import com.marsrover.model.Position;
import com.marsrover.structural.strategy.Direction;
import com.marsrover.exception.RoverException;
import com.marsrover.util.RoverLogger;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main application class for Mars Rover Simulation
 * NOW WITH INTERACTIVE USER INPUT
 */
public class MarsRoverApplication {
    private final RoverLogger logger;
    private final Scanner scanner;
    
    public MarsRoverApplication() {
        this.logger = RoverLogger.getInstance();
        this.scanner = new Scanner(System.in);
    }
    
    public void runSimulation(int gridWidth, int gridHeight,
                             int startX, int startY, String startDirection,
                             String[] commands, int[][] obstacles) {
        try {
            // Build Rover using Builder Pattern
            Rover rover = new RoverBuilder()
                .setGridSize(gridWidth, gridHeight)
                .setStartingPosition(startX, startY)
                .setStartingDirection(startDirection)
                .addObstacles(obstacles)
                .build();
            
            // Create command invoker
            CommandInvoker invoker = new CommandInvoker(rover);
            
            // Create commands using Factory Pattern
            List<Command> commandObjects = CommandFactory.createCommands(commands);
            
            // Execute commands
            invoker.executeCommands(commandObjects);
            
            // Display final status
            System.out.println("\n" + "=".repeat(70));
            System.out.println("FINAL OUTPUT");
            System.out.println("=".repeat(70));
            
            StatusReport status = rover.getStatusReport();
            Position finalPos = status.getPosition();
            Direction finalDir = status.getDirection();
            
            System.out.printf("Final Position: (%d, %d, %s)%n",
                finalPos.getX(), finalPos.getY(), finalDir.getSymbol());
            System.out.printf("Status Report: \"%s\"%n", status.getFormattedReport());
            System.out.println("=".repeat(70) + "\n");
            
        } catch (RoverException e) {
            logger.error("Simulation failed: " + e.getMessage());
            System.out.println("\n❌ ERROR: " + e.getMessage());
        } catch (Exception e) {
            logger.critical("Unexpected error: " + e.getMessage());
            System.out.println("\n❌ CRITICAL ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Interactive user input method - Exact format as specified
     */
    public void runInteractiveMode() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("USER INPUT MODE");
        System.out.println("=".repeat(70));
        System.out.println("\nPlease enter the following information:");
        System.out.println("-".repeat(70));
        
        try {
            scanner.nextLine(); // consume any leftover newline
            
            // Get Grid Size
            System.out.print("Grid Size: ");
            String gridInput = scanner.nextLine().trim();
            String[] gridParts = gridInput.replaceAll("[()]", "").split("x");
            int gridWidth = Integer.parseInt(gridParts[0].trim());
            int gridHeight = Integer.parseInt(gridParts[1].trim());
            
            // Get Starting Position
            System.out.print("Starting Position: ");
            String posInput = scanner.nextLine().trim();
            String[] posParts = posInput.replaceAll("[()]", "").split(",");
            int startX = Integer.parseInt(posParts[0].trim());
            int startY = Integer.parseInt(posParts[1].trim());
            String startDirection = posParts[2].trim().toUpperCase();
            
            // Get Commands
            System.out.print("Commands: ");
            String commandInput = scanner.nextLine().trim();
            commandInput = commandInput.replaceAll("[\\[\\]\\s']", "");
            String[] commands = commandInput.split(",");
            
            // Get Obstacles
            System.out.print("Obstacles: ");
            String obstacleInput = scanner.nextLine().trim();
            obstacleInput = obstacleInput.replaceAll("[\\[\\]()]", "");
            
            int[][] obstacles;
            if (obstacleInput.isEmpty()) {
                obstacles = new int[0][2];
            } else {
                String[] obstaclePairs = obstacleInput.split("\\),\\s*");
                obstacles = new int[obstaclePairs.length][2];
                for (int i = 0; i < obstaclePairs.length; i++) {
                    String[] coords = obstaclePairs[i].split(",");
                    obstacles[i][0] = Integer.parseInt(coords[0].trim());
                    obstacles[i][1] = Integer.parseInt(coords[1].trim());
                }
            }
            
            // Display parsed configuration
            System.out.println("\n" + "-".repeat(70));
            System.out.println("Parsed Configuration:");
            System.out.println("-".repeat(70));
            System.out.printf("Grid Size: (%d x %d)%n", gridWidth, gridHeight);
            System.out.printf("Starting Position: (%d, %d, %s)%n", startX, startY, startDirection);
            System.out.print("Commands: [");
            for (int i = 0; i < commands.length; i++) {
                System.out.print("'" + commands[i] + "'");
                if (i < commands.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.print("Obstacles: [");
            for (int i = 0; i < obstacles.length; i++) {
                System.out.printf("(%d, %d)", obstacles[i][0], obstacles[i][1]);
                if (i < obstacles.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("-".repeat(70));
            
            // Run simulation
            runSimulation(gridWidth, gridHeight, startX, startY, startDirection, commands, obstacles);
            
        } catch (Exception e) {
            System.out.println("\n❌ Invalid input format: " + e.getMessage());
            System.out.println("\nExpected format:");
            System.out.println("Grid Size: (10 x 10)");
            System.out.println("Starting Position: (0, 0, N)");
            System.out.println("Commands: ['M', 'M', 'R', 'M', 'L', 'M']");
            System.out.println("Obstacles: [(2, 2), (3, 5)]");
        }
    }
    

    
    public void runDefaultScenario() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("DEFAULT SCENARIO (From Problem Statement)");
        System.out.println("=".repeat(70));
        System.out.println("\nInput Configuration:");
        System.out.println("  Grid Size: (10 x 10)");
        System.out.println("  Starting Position: (0, 0, N)");
        System.out.println("  Commands: ['M', 'M', 'R', 'M', 'L', 'M']");
        System.out.println("  Obstacles: [(2, 2), (3, 5)]");
        System.out.println("\nExpected Output:");
        System.out.println("  Final Position: (1, 3, N)");
        System.out.println("  Status Report: \"Rover is at (1, 3) facing North. No Obstacles detected.\"");
        System.out.println("\nActual Execution:");
        System.out.println("-".repeat(70));
        
        runSimulation(
            10, 10,
            0, 0, "N",
            new String[]{"M", "M", "R", "M", "L", "M"},
            new int[][]{{2, 2}, {3, 5}}
        );
    }
    
    /**
     * Main entry point with menu
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("MARS ROVER SIMULATION - ENTERPRISE JAVA APPLICATION");
        System.out.println("=".repeat(70));
        System.out.println("\nDesign Patterns Implemented:");
        System.out.println("  ✓ Command Pattern (behavioral)");
        System.out.println("  ✓ Strategy Pattern (structural)");
        System.out.println("  ✓ Composite Pattern (structural)");
        System.out.println("  ✓ Factory Pattern (creational)");
        System.out.println("  ✓ Builder Pattern (creational)");
        System.out.println("  ✓ Singleton Pattern (creational)");
        System.out.println("\nSOLID Principles: Fully Applied");
        System.out.println("=".repeat(70));
        
        MarsRoverApplication app = new MarsRoverApplication();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n" + "=".repeat(70));
            System.out.println("MAIN MENU");
            System.out.println("=".repeat(70));
            System.out.println("1. User Input Mode");
            System.out.println("2. Run Default Scenario");
            System.out.println("3. Exit");
            System.out.println("=".repeat(70));
            System.out.print("\nSelect option (1-3): ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        app.runInteractiveMode();
                        break;
                    case 2:
                        app.runDefaultScenario();
                        break;
                    case 3:
                        System.out.println("\nExiting Mars Rover Simulation. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("\n❌ Invalid option. Please select 1-3.");
                }
                
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
                
            } catch (Exception e) {
                System.out.println("\n❌ Invalid input. Please enter a number.");
                scanner.nextLine(); // clear buffer
            }
        }
    }
}