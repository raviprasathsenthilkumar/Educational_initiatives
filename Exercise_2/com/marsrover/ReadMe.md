# Mars Rover Simulation - Enterprise Java Application

## Overview
A sophisticated Mars Rover navigation system demonstrating enterprise-level Java design patterns, SOLID principles, and clean architecture. The rover navigates a grid-based terrain, executes movement commands, and detects obstacles in its path.

---

## Design Patterns Implemented

### Creational Patterns
- **Singleton Pattern**: Thread-safe logger implementation (RoverLogger)
- **Builder Pattern**: Flexible rover and grid configuration (RoverBuilder)
- **Factory Pattern**: Object creation for directions and commands (DirectionFactory, CommandFactory)

### Structural Patterns
- **Strategy Pattern**: Polymorphic direction behavior (North, South, East, West)
- **Composite Pattern**: Hierarchical grid and obstacle management (Grid, Obstacle)

### Behavioral Patterns
- **Command Pattern**: Encapsulated rover actions (MoveCommand, TurnLeftCommand, TurnRightCommand)

---

## Project Structure

```
com/marsrover/
├── MarsRoverApplication.java          # Main application entry point
│
├── exception/                         # Custom exceptions
│   ├── RoverException.java           # Base exception class
│   ├── InvalidPositionException.java
│   ├── ObstacleDetectedException.java
│   ├── InvalidCommandException.java
│   └── InvalidDirectionException.java
│
├── util/                              # Utility classes
│   └── RoverLogger.java              # Singleton logger
│
├── model/                             # Domain models
│   ├── Position.java                 # Immutable position value object
│   ├── StatusReport.java             # Rover status reporting
│   └── Rover.java                    # Core rover entity
│
├── behavioral/command/                # Command Pattern
│   ├── Command.java                  # Command interface
│   ├── MoveCommand.java
│   ├── TurnLeftCommand.java
│   ├── TurnRightCommand.java
│   └── CommandInvoker.java           # Command executor
│
├── structural/
│   ├── strategy/                     # Strategy Pattern
│   │   ├── Direction.java           # Strategy interface
│   │   ├── North.java
│   │   ├── South.java
│   │   ├── East.java
│   │   └── West.java
│   │
│   └── composite/                    # Composite Pattern
│       ├── GridComponent.java       # Component interface
│       ├── Obstacle.java            # Leaf component
│       └── Grid.java                # Composite component
│
└── creational/
    ├── factory/                      # Factory Pattern
    │   ├── DirectionFactory.java
    │   └── CommandFactory.java
    │
    └── builder/                      # Builder Pattern
        └── RoverBuilder.java
```

---

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal (PowerShell, CMD, or Bash)

### Step 1: Navigate to Project Directory
```bash
cd path/to/Educational_initiatives/Exercise_2
```

### Step 2: Compile the Code

**On Windows (PowerShell/CMD):**
```powershell
javac com/marsrover/*.java com/marsrover/exception/*.java com/marsrover/util/*.java com/marsrover/model/*.java com/marsrover/behavioral/command/*.java com/marsrover/structural/strategy/*.java com/marsrover/structural/composite/*.java com/marsrover/creational/factory/*.java com/marsrover/creational/builder/*.java
```

**On Linux/Mac:**
```bash
javac com/marsrover/**/*.java com/marsrover/*.java
```

**Alternative (All Platforms) - Using sources file:**
Create a file named `sources.txt` with all Java file paths, then:
```bash
javac @sources.txt
```

### Step 3: Run the Application
```bash
java com.marsrover.MarsRoverApplication
```

---

## Usage Guide

### Main Menu Options

```
======================================================================
MAIN MENU
======================================================================
1. User Input Mode
2. Run Default Scenario
3. Exit
======================================================================
```

### Option 1: User Input Mode

**Input Format:**
```
Grid Size: (10 x 10)
Starting Position: (0, 0, N)
Commands: ['M', 'M', 'R', 'M', 'L', 'M']
Obstacles: [(2, 2), (3, 5)]
```

**Command Symbols:**
- `M` - Move forward one step
- `L` - Turn left (90 degrees counter-clockwise)
- `R` - Turn right (90 degrees clockwise)

**Direction Symbols:**
- `N` - North
- `S` - South
- `E` - East
- `W` - West

---

## Use Cases

### Use Case 1: Basic Navigation
**Scenario**: Navigate rover through simple path without obstacles

**Input:**
```
Grid Size: (10 x 10)
Starting Position: (0, 0, N)
Commands: ['M', 'M', 'R', 'M', 'M']
Obstacles: []
```

**Expected Output:**
```
Final Position: (2, 2, E)
Status Report: "Rover is at (2, 2) facing East. No obstacles detected."
```

**Business Value**: Validates basic movement and turning functionality

---

### Use Case 2: Obstacle Detection
**Scenario**: Rover encounters obstacle and stops

**Input:**
```
Grid Size: (5 x 5)
Starting Position: (0, 0, N)
Commands: ['M', 'M', 'M']
Obstacles: [(0, 2)]
```

**Expected Output:**
```
Final Position: (0, 1, N)
Status Report: "Rover is at (0, 1) facing North. Obstacle detected in last move."
```

**Business Value**: Ensures safety by preventing collision with obstacles

---

### Use Case 3: Boundary Validation
**Scenario**: Rover attempts to move outside grid boundaries

**Input:**
```
Grid Size: (5 x 5)
Starting Position: (4, 4, N)
Commands: ['M', 'R', 'M']
Obstacles: []
```

**Expected Output:**
```
ERROR: Position (4, 5) is outside grid boundaries
```

**Business Value**: Prevents rover from navigating into invalid terrain

---

### Use Case 4: Complex Navigation Path
**Scenario**: Execute multiple turns and movements around obstacles

**Input:**
```
Grid Size: (10 x 10)
Starting Position: (0, 0, N)
Commands: ['M', 'M', 'R', 'M', 'L', 'M']
Obstacles: [(2, 2), (3, 5)]
```

**Expected Output:**
```
Final Position: (1, 3, N)
Status Report: "Rover is at (1, 3) facing North. No obstacles detected."
```

**Business Value**: Demonstrates ability to navigate complex terrain with multiple obstacles

---

### Use Case 5: Square Pattern Navigation
**Scenario**: Navigate rover in a square pattern

**Input:**
```
Grid Size: (10 x 10)
Starting Position: (5, 5, N)
Commands: ['M', 'M', 'R', 'M', 'M', 'R', 'M', 'M', 'R', 'M', 'M']
Obstacles: []
```

**Expected Output:**
```
Final Position: (5, 5, W)
Status Report: "Rover is at (5, 5) facing West. No obstacles detected."
```

**Business Value**: Tests complete rotation and return-to-origin capability

---

### Use Case 6: Obstacle Avoidance Planning
**Scenario**: Navigate around multiple obstacles in path

**Input:**
```
Grid Size: (8 x 8)
Starting Position: (0, 0, N)
Commands: ['M', 'R', 'M', 'M', 'L', 'M', 'M', 'L', 'M']
Obstacles: [(0, 1), (1, 1), (2, 1)]
```

**Expected Output:**
```
Final Position: (2, 3, W)
Status Report: "Rover is at (2, 3) facing West. No obstacles detected."
```

**Business Value**: Demonstrates intelligent path planning around obstacle clusters

---

### Use Case 7: Emergency Stop
**Scenario**: Immediate obstacle detection stops command execution

**Input:**
```
Grid Size: (5 x 5)
Starting Position: (2, 0, N)
Commands: ['M', 'M', 'M', 'M', 'M']
Obstacles: [(2, 3)]
```

**Expected Output:**
```
Final Position: (2, 2, N)
Status Report: "Rover is at (2, 2) facing North. Obstacle detected in last move."
Command sequence stopped due to obstacle
```

**Business Value**: Safety feature preventing damage from continuous movement

---

### Use Case 8: Direction Changes Only
**Scenario**: Multiple rotations without movement

**Input:**
```
Grid Size: (10 x 10)
Starting Position: (5, 5, N)
Commands: ['R', 'R', 'R', 'R']
Obstacles: []
```

**Expected Output:**
```
Final Position: (5, 5, N)
Status Report: "Rover is at (5, 5) facing North. No obstacles detected."
```

**Business Value**: Validates orientation system without position change

---

## SOLID Principles Applied

### Single Responsibility Principle (SRP)
- Each class has one clear responsibility
- `Rover` handles navigation, `Grid` handles terrain, `Logger` handles logging

### Open/Closed Principle (OCP)
- New directions can be added without modifying existing code
- New commands can be added via factory pattern

### Liskov Substitution Principle (LSP)
- All `Direction` implementations are interchangeable
- All `Command` implementations can be executed polymorphically

### Interface Segregation Principle (ISP)
- Small, focused interfaces (`Direction`, `Command`, `GridComponent`)
- Clients depend only on methods they use

### Dependency Inversion Principle (DIP)
- High-level modules depend on abstractions (interfaces)
- `Rover` depends on `Direction` interface, not concrete implementations

---

## Error Handling

The application handles various error scenarios:
- **InvalidPositionException**: Position outside grid or negative coordinates
- **ObstacleDetectedException**: Obstacle in movement path
- **InvalidCommandException**: Unknown command symbol
- **InvalidDirectionException**: Unknown direction symbol

---

## Sample Execution

```
PS C:\...\Exercise_2> java com.marsrover.MarsRoverApplication

======================================================================
MARS ROVER SIMULATION - ENTERPRISE JAVA APPLICATION
======================================================================
Design Patterns Implemented:
  -Command Pattern (behavioral)
  -Strategy Pattern (structural)
  -Composite Pattern (structural)
  -Factory Pattern (creational)
  -Builder Pattern (creational)
  -Singleton Pattern (creational)
  
SOLID Principles: Fully Applied
======================================================================

Select option (1-3): 1

USER INPUT MODE
Please enter the following information:
----------------------------------------------------------------------
Grid Size: (10 x 10)
Starting Position: (0, 0, N)
Commands: ['M', 'M', 'R', 'M', 'L', 'M']
Obstacles: [(2, 2), (3, 5)]

----------------------------------------------------------------------
FINAL OUTPUT
----------------------------------------------------------------------
Final Position: (1, 3, N)
Status Report: "Rover is at (1, 3) facing North. No obstacles detected."
----------------------------------------------------------------------
```

---
