package com.designpatterns.creational.singleton;

/**
 * Service class demonstrating Logger usage
 * Follows Dependency Inversion Principle
 */
public class UserService {
    private Logger logger;
    
    public UserService() {
        this.logger = Logger.getInstance();
    }
    
    public void createUser(String username) {
        logger.info("UserService: Creating user - " + username);
        
        if (username == null || username.trim().isEmpty()) {
            logger.error("UserService: User creation failed - username is null or empty");
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        if (username.length() < 3) {
            logger.warning("UserService: Username is too short - " + username);
        }
        
        // Simulate user creation
        logger.info("UserService: User created successfully - " + username);
    }
    
    public void deleteUser(String username) {
        logger.warning("UserService: Attempting to delete user - " + username);
        
        if (username == null || username.trim().isEmpty()) {
            logger.error("UserService: User deletion failed - username is null or empty");
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // Simulate user deletion
        logger.info("UserService: User deleted - " + username);
    }
    
    public void updateUser(String username, String newEmail) {
        logger.info("UserService: Updating user - " + username);
        
        if (newEmail == null || !newEmail.contains("@")) {
            logger.error("UserService: Invalid email format - " + newEmail);
            throw new IllegalArgumentException("Invalid email format");
        }
        
        logger.info("UserService: User updated successfully - " + username);
    }
}