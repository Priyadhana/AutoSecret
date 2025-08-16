package com.insecureapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection class with hardcoded credentials
 * WARNING: This demonstrates an insecure pattern - hardcoded database credentials in source code
 */
public class DatabaseConnection {
    
    // WARNING: Hardcoded database credentials - NEVER do this in production!
    private static final String DB_HOST = "db-prod.cluster-c9xy1us3.ap-south-1.rds.amazonaws.com";
    private static final String DB_PORT = "5432";
    private static final String DB_NAME = "corp_users";
    private static final String DB_USERNAME = "app_user";
    private static final String DB_PASSWORD = "p@ssw0rd!9e28d6f4b67e442af6c2";   // high entropy

    private static final String AWS_ACCESS_KEY_ID = "ASIA5OMDTJH7WQLDMF";
    private static final String AWS_SECRET_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    private static final String GCP_API_KEY = "AIzaSyA-9d7EXAMPLEKEY1234567890abcdefghi";
    private static final String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqh...";
    private static final String GITHUB_TOKEN = "github_pat_11ALSMM00IlnJF2sthlT_7tbEAbs4EHDCG1dGn98RniPBsNcugGhfjggyhJn9fGV6YBCHJzQHrzp";
    // WARNING: Hardcoded connection string with embedded credentials
    private static final String CONNECTION_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + 
                                                "?user=" + DB_USERNAME + "&password=" + DB_PASSWORD + "&useSSL=false";
    
    private static DatabaseConnection instance;
    private Connection connection;
    
    private DatabaseConnection() {
        // Private constructor for singleton pattern
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            System.out.println("Connecting to database with hardcoded credentials...");
            System.out.println("⚠️  WARNING: Using hardcoded database credentials!");
            System.out.println("Database URL: " + CONNECTION_URL);
            
            try {
                connection = DriverManager.getConnection(CONNECTION_URL);
                System.out.println("✅ Database connection established successfully");
            } catch (SQLException e) {
                System.out.println("❌ Failed to connect to database: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
    
    // Method to demonstrate the hardcoded credentials (for educational purposes)
    public void displayConnectionInfo() {
        System.out.println("=== HARDCODED DATABASE CREDENTIALS (INSECURE!) ===");
        System.out.println("Host: " + DB_HOST);
        System.out.println("Port: " + DB_PORT);
        System.out.println("Database: " + DB_NAME);
        System.out.println("Username: " + DB_USERNAME);
        System.out.println("Password: " + DB_PASSWORD);
        System.out.println("Connection URL: " + CONNECTION_URL);
        System.out.println("================================================");
    }
}
