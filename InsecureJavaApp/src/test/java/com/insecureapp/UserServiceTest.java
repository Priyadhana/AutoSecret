package com.insecureapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UserService
 * WARNING: These tests demonstrate using hardcoded database credentials
 */
public class UserServiceTest {
    
    private UserService userService;
    
    @BeforeEach
    void setUp() {
        userService = new UserService();
        System.out.println("⚠️  Setting up tests with hardcoded database credentials (EDUCATIONAL ONLY!)");
    }
    
    @Test
    void testDatabaseConnection() {
        // This test demonstrates the hardcoded credentials
        System.out.println("Testing database connection with hardcoded credentials...");
        
        // The DatabaseConnection class will display the hardcoded credentials
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.displayConnectionInfo();
        
        // This test will fail if no database is running, but that's expected
        // The important part is that it shows the hardcoded credentials
        assertNotNull(dbConnection);
        System.out.println("✅ Database connection test completed (credentials displayed)");
    }
    
    @Test
    void testUserCreation() {
        System.out.println("Testing user creation with hardcoded database credentials...");
        
        User testUser = new User(0, "test_user", "test@example.com", "Test User");
        assertNotNull(testUser);
        assertEquals("test_user", testUser.getUsername());
        assertEquals("test@example.com", testUser.getEmail());
        assertEquals("Test User", testUser.getFullName());
        
        System.out.println("✅ User creation test completed");
    }
    
    @Test
    void testUserServiceInitialization() {
        System.out.println("Testing UserService initialization with hardcoded credentials...");
        
        assertNotNull(userService);
        System.out.println("✅ UserService initialization test completed");
    }
}
