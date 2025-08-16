package com.insecureapp;

import java.sql.*;

/**
 * UserService class that demonstrates a realistic application using hardcoded database credentials
 * WARNING: This demonstrates an insecure pattern - hardcoded database credentials in source code
 */
public class UserService {
    
    private final DatabaseConnection dbConnection;
    
    public UserService() {
        this.dbConnection = DatabaseConnection.getInstance();
    }
    
    /**
     * Demonstrate the application functionality
     */
    public void demonstrateApplication() {
        System.out.println("🚀 Starting InsecureJavaApp Demo");
        System.out.println("⚠️  This application uses hardcoded database credentials!");
        
        // Display hardcoded credentials (for educational purposes)
        dbConnection.displayConnectionInfo();
        
        try {
            // Try to connect to database (will fail if no database is running)
            System.out.println("Attempting to connect to database...");
            Connection conn = dbConnection.getConnection();
            System.out.println("✅ Successfully connected to database!");
            
            // Close the connection
            dbConnection.closeConnection();
            
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
            System.out.println("This is expected if no MySQL database is running.");
            System.out.println("The important part is that the hardcoded credentials were displayed above.");
        }
        
        System.out.println("✅ InsecureJavaApp demo completed");
        System.out.println("⚠️  Remember: Never use hardcoded credentials in production!");
    }
    
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.demonstrateApplication();
    }
}
