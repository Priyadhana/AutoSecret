# InsecureJavaApp - Realistic Java Application with Hardcoded Database Credentials

⚠️ **WARNING: This project demonstrates INSECURE database credential handling for educational purposes only!**

This is a realistic Java application that mimics a real-world scenario where database credentials are hardcoded directly in the source code. This is a common but extremely insecure practice that should never be used in production.

## 🚨 Security Disclaimer

**NEVER use these patterns in production!** This project is for educational purposes only and demonstrates an insecure way of handling database credentials that should be avoided at all costs.

## 📁 Project Structure

```
InsecureJavaApp/
├── build.gradle                    # Gradle build configuration
├── gradlew                         # Gradle wrapper script
├── gradlew.bat                     # Gradle wrapper script (Windows)
├── gradle/wrapper/                 # Gradle wrapper files
├── src/
│   ├── main/
│   │   ├── java/com/insecureapp/
│   │   │   ├── User.java              # User model class
│   │   │   ├── DatabaseConnection.java # Database connection with hardcoded credentials
│   │   │   └── UserService.java       # Main service class
│   │   └── resources/
│   │       └── logback.xml            # Logging configuration
│   └── test/
│       └── java/com/insecureapp/
│           └── UserServiceTest.java   # Tests with hardcoded credentials
└── README.md                        # This file
```

## 🔐 Hardcoded Credentials Demonstrated

The application contains the following hardcoded database credentials in `DatabaseConnection.java`:

```java
// WARNING: Hardcoded database credentials - NEVER do this in production!
private static final String DB_HOST = "localhost";
private static final String DB_PORT = "3306";
private static final String DB_NAME = "userdb";
private static final String DB_USERNAME = "admin";
private static final String DB_PASSWORD = "secret123";
```

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- MySQL database (optional - for full functionality)
- Gradle (included via wrapper)

### Building the Project
```bash
# Make gradlew executable (Unix/macOS)
chmod +x gradlew

# Build the project
./gradlew build
```

### Running the Application

#### Option 1: Run without Database (Shows Hardcoded Credentials)
```bash
# Run the application - it will show the hardcoded credentials
./gradlew run
```

This will:
- Display all hardcoded database credentials
- Attempt to connect to the database (will fail if no database is running)
- Show the insecure patterns used

#### Option 2: Run with MySQL Database (Full Functionality)

1. **Set up MySQL database:**
```sql
-- Create database
CREATE DATABASE userdb;

-- Create user (optional - you can use root)
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'secret123';
GRANT ALL PRIVILEGES ON userdb.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;
```

2. **Run the application:**
```bash
./gradlew run
```

This will:
- Connect to the database using hardcoded credentials
- Create a `users` table
- Insert sample users
- Demonstrate CRUD operations
- Show all hardcoded credentials in the logs

### Running Tests
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests UserServiceTest
```

## 📋 What the Application Does

1. **DatabaseConnection**: Manages database connections using hardcoded credentials
2. **UserService**: Provides user management functionality (CRUD operations)
3. **User**: Simple user model class
4. **Tests**: Demonstrate the hardcoded credential patterns

## 🔍 Generated Files

When you run the application, it will generate:
- `logs/insecure-app.log` - Application logs (including hardcoded credentials)

## ⚠️ Security Anti-Patterns Demonstrated

### ❌ What NOT to do (shown in this project):

1. **Hardcode database credentials in source code**
2. **Embed passwords in connection strings**
3. **Store credentials in version control**
4. **Use simple, predictable passwords**
5. **Log credentials to files**

### ✅ What you SHOULD do instead:

1. **Use environment variables**
2. **Use configuration management services**
3. **Use secret management services** (AWS Secrets Manager, HashiCorp Vault, etc.)
4. **Use encrypted configuration files**
5. **Use secure credential injection**
6. **Use strong, randomly generated passwords**

## 🛡️ Secure Alternatives

### Environment Variables
```bash
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=userdb
export DB_USERNAME=admin
export DB_PASSWORD=$(aws secretsmanager get-secret-value --secret-id db-password --query SecretString --output text)
```

### Configuration Management
```java
// Use Spring Boot application.properties or similar
@Value("${database.host}")
private String dbHost;

@Value("${database.password}")
private String dbPassword;
```

### Secret Management Services
- AWS Secrets Manager
- HashiCorp Vault
- Azure Key Vault
- Google Secret Manager

## 🧪 Testing the Application

### Test 1: View Hardcoded Credentials
```bash
./gradlew run
```
This will display all hardcoded credentials in the console.

### Test 2: Run Tests (No Database Required)
```bash
./gradlew test
```
This will run tests that demonstrate the hardcoded credential patterns.

### Test 3: Full Database Test (Requires MySQL)
1. Set up MySQL database as described above
2. Run `./gradlew run`
3. Check the logs for successful database operations

## 📝 Logging

The application uses SLF4J with Logback for logging. Logs are written to both console and file (`logs/insecure-app.log`).

**Important**: The logs will contain the hardcoded credentials, demonstrating another security anti-pattern.

## 🚨 Important Notes

1. **This is for educational purposes only**
2. **Never use these patterns in production**
3. **The credentials in this project are fake/demo values**
4. **Always use proper credential management in real applications**
5. **Consider this a "what not to do" guide**

## 📚 Learning Resources

- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [OWASP Cheat Sheet Series](https://cheatsheetseries.owasp.org/)
- [AWS Security Best Practices](https://aws.amazon.com/security/security-learning/)
- [HashiCorp Vault Documentation](https://www.vaultproject.io/docs)

---

**Remember: Security is everyone's responsibility!** 🔒
