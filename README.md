# 🍣 Sushi Ordering System

[![Made With Java][made-with-java]][forthebadge-url]
[![Built With Love][built-with-love]][forthebadge-url]

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-issues-url]

A comprehensive **desktop restaurant ordering system** built with Java Swing that provides a complete sushi ordering experience. This academic project demonstrates enterprise-level software development practices for restaurant order management, customer authentication, cart functionality, and order processing with integrated SMS notification system.

## 📋 Table of Contents
- [🎯 Project Overview](#-project-overview)
- [✨ Key Features](#-key-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [🏗️ Architecture](#️-architecture)
- [📁 Project Structure](#-project-structure)
- [🚀 Quick Start](#-quick-start)
- [⚙️ Configuration](#️-configuration)
- [📱 Usage Guide](#-usage-guide)
- [🔐 Security Notes](#-security-notes)
- [🚀 Deployment](#-deployment)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [📷 Screenshots](#-screenshots)

## 🎯 Project Overview

**Sushi Ordering System** is a sophisticated desktop application that recreates the restaurant ordering experience in a rich graphical user interface. Built as an academic project using Java Swing and MySQL, it demonstrates modern software development principles while providing a fully functional ordering platform for sushi restaurants.

### 🎯 Target Users
- **🍣 Restaurant Customers**: Browse menu, place orders, manage cart, receive SMS confirmations
- **👥 Restaurant Staff**: Process orders, manage customer data, track sales

### 🌟 Problem Statement
Deliver an academic demonstration of a complete restaurant ordering flow (browse menu → add to cart → checkout → order confirmation → SMS notification) using Java Swing + MySQL with integrated customer management system.

## ✨ Key Features

### 🍱 **Sushi Menu Management**
- **Menu Display**: Interactive sushi selection with high-quality images
- **Item Categories**: Aburi, Ama Ebi, Kani, Tamago, Saki, and Maki varieties
- **Pricing System**: Individual item pricing (₱39.00 - ₱59.00)
- **Quantity Selection**: Spinner controls for quantity selection (1-100 items)
- **Visual Feedback**: Hover effects and selection indicators

### 🧾 **Order & Receipt System**
- **Add/Remove Items**: Manage selected sushi items and quantities
- **Real-time Updates**: Dynamic order total calculation
- **Receipt Generation**: Professional receipt printing with itemized billing
- **Customer Details**: Complete customer information on receipts
- **Order Validation**: Empty cart alerts and quantity limits
- **Clear Orders**: Option to clear all items at once

### 🔐 **Customer Authentication & Management**
- **Registration System**: Username, password, full name, mobile number, address
- **Login Authentication**: Secure credential verification against database
- **Customer Profiles**: Store and manage customer information
- **Input Validation**: Phone number format validation and duplicate checking
- **Password Security**: Encrypted password storage with validation

### 📱 **SMS Notification System**
- **Order Confirmation**: SMS alerts for successful orders
- **OTP Verification**: Two-factor authentication via SMS
- **Customer Notifications**: Order status updates and confirmations
- **Mobile Integration**: Direct SMS sending capabilities

### 📊 **Order Processing & Management**
- **Order Creation**: Complete order workflow from cart to confirmation
- **Order Tracking**: Unique order ID generation and tracking
- **Sales Recording**: Detailed sales data storage in database
- **Date/Time Stamps**: Automatic order timestamp recording
- **Order History**: Customer order history and tracking

### 🎨 **Advanced UI/UX Features**
- **Rounded Panels**: Custom rounded panel components for modern look
- **Loading Screens**: Professional loading animations and splash screens
- **Interactive Elements**: Hover effects, button states, and visual feedback
- **Error Handling**: User-friendly error dialogs and validation messages
- **Responsive Design**: Adaptive layout for different screen sizes

## 🛠️ Tech Stack

### **Core Technologies**
- **Language**: Java 8+
- **GUI Framework**: Java Swing with NetBeans GUI Builder
- **Database**: MySQL/MariaDB with JDBC connectivity
- **Build Tool**: Apache Maven 3.x
- **IDE**: NetBeans IDE (recommended)

### **Java Libraries & Dependencies**
- **MySQL Connector**: `mysql-connector-java:8.0.29`
- **HTTP Components**: `httpclient:4.5.13`, `httpcore:4.4.13`
- **AbsoluteLayout**: NetBeans layout manager for precise component positioning
- **Java AWT/Swing**: Core GUI components and event handling
- **JDBC**: Database connectivity and SQL operations

### **Development Tools**
- **NetBeans GUI Builder**: Visual form designer for Swing interfaces
- **Maven**: Dependency management and project building
- **phpMyAdmin**: Database management via XAMPP
- **Git**: Version control and collaboration
- **ProGuard**: Code obfuscation for production builds

### **Architecture Patterns**
- **MVC Pattern**: Separation of Model (data), View (UI), Controller (logic)
- **Observer Pattern**: Event-driven UI updates and notifications
- **Singleton Pattern**: Database connection management
- **Factory Pattern**: Component creation and initialization

## 🏗️ Architecture

### **System Architecture**
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│  Presentation   │    │   Business      │    │   Data Layer    │
│     Layer       │    │     Logic       │    │                 │
│                 │    │                 │    │                 │
│ ┌─────────────┐ │    │ ┌─────────────┐ │    │ ┌─────────────┐ │
│ │    Swing    │ │    │ │   Models    │ │    │ │   MySQL     │ │
│ │     UI      │◄├────┤►│   Classes   │◄├────┤►│  Database   │ │
│ └─────────────┘ │    │ └─────────────┘ │    │ └─────────────┘ │
│ ┌─────────────┐ │    │ ┌─────────────┐ │    │ ┌─────────────┐ │
│ │   Event     │ │    │ │   Service   │ │    │ │    JDBC     │ │
│ │  Handlers   │ │    │ │   Classes   │ │    │ │ Connection  │ │
│ └─────────────┘ │    │ └─────────────┘ │    │ └─────────────┘ │
└─────────────────┘    └─────────────────┘    └─────────────────┘
```

### **Database Schema**
```sql
-- Core Tables
customers (customer_id, user_name, user_pass, full_name, mobile_no, user_addr)
sales (order_id, order_created, item_name, item_quantity, unit_price, total_amount)

-- Relationships
- Customers can place multiple orders
- Sales records linked to customer orders via order_id
- Order tracking with date/time stamps
- Foreign key constraints for data integrity
```

### **Class Hierarchy**
```
Sushi Ordering System
├── Init.java (Application Entry Point)
├── SplashScreen.java (Loading Screen)
├── LoginForm.java (Authentication UI)
├── MainMenu.java (Main Application Window)
├── Models/
│   ├── Customer.java (Customer data model)
│   ├── Order.java (Order data model)
│   └── DecimalFormatter.java (Price formatting)
├── Services/
│   ├── SushiDBConnection.java (Database connectivity)
│   ├── SendSMS.java (SMS notification service)
│   └── OTP.java (Two-factor authentication)
├── UI Components/
│   ├── RoundedPanel.java (Custom rounded panels)
│   ├── TextPrompt.java (Input field placeholders)
│   └── Various Dialog Components
└── Utilities/
    ├── OrderTableModel.java (Table data management)
    └── Loading Screens (Loading, Loading2, Loading3)
```

## 📁 Project Structure

```
sushi-ordering-system/
├── 📄 pom.xml                           # Maven project configuration
├── 📄 README.md                         # Project documentation
├── 📄 nbactions.xml                     # NetBeans IDE actions
├── 📄 nb-configuration.xml              # NetBeans configuration
├── 📁 database/
│   └── 📄 sushi_restaurant.sql          # Database schema and sample data
├── 📁 src/restaurantorderingandpayment/
│   ├── 📄 Init.java                     # Application entry point
│   ├── 📄 SplashScreen.java            # Loading screen with progress bar
│   ├── 📄 LoginForm.java               # User authentication interface
│   ├── 📄 MainMenu.java                # Main ordering interface
│   ├── 📄 SushiDBConnection.java       # Database connectivity
│   ├── 📄 Customer.java                # Customer data model
│   ├── 📄 Order.java                   # Order data model
│   ├── 📄 OrderTableModel.java         # Table data management
│   ├── 📄 SendSMS.java                 # SMS notification service
│   ├── 📄 SMS2.java                    # Alternative SMS implementation
│   ├── 📄 OTP.java                     # OTP generation and validation
│   ├── 📄 OTPDialog.java               # OTP input dialog
│   ├── 📄 RoundedPanel.java            # Custom UI component
│   ├── 📄 TextPrompt.java              # Input field enhancements
│   ├── 📄 Loading.java                 # Loading dialog (Order processing)
│   ├── 📄 Loading2.java                # Loading dialog (SMS sending)
│   ├── 📄 Loading3.java                # Loading dialog (Confirmation)
│   ├── 📄 Success.java                 # Order success dialog
│   ├── 📄 Thankyou.java                # Thank you message dialog
│   ├── 📄 CartIsEmptyAlert.java        # Empty cart warning
│   ├── 📄 MaximumAlert.java            # Quantity limit warning
│   ├── 📄 QuantityAlert.java           # Invalid quantity warning
│   ├── 📄 ConfirmDialog.java           # Order confirmation dialog
│   ├── 📄 InformationDialog.java       # Information display dialog
│   ├── 📄 InvalidAccount.java          # Invalid login alert
│   ├── 📄 DatabaseError.java           # Database error dialog
│   └── 📁 images/                      # UI assets and sushi images
│       ├── sushi1.png - sushi6.png     # Sushi item images
│       ├── brandIcon.png               # Application branding
│       ├── loading.gif                 # Loading animations
│       ├── splash.gif                  # Splash screen animation
│       └── Various UI icons
└── 📁 target/                          # Maven build output
    ├── 📁 classes/                     # Compiled Java classes
    └── 📁 libs/                        # Dependencies
```

### **Key Components Explained**

- **`Init.java`**: Application bootstrap with animated splash screen
- **`LoginForm.java`**: Complete authentication system with registration and validation
- **`MainMenu.java`**: Primary ordering interface with menu display and cart management
- **`SushiDBConnection.java`**: Database connection utility with MySQL integration
- **Model Classes**: Data structures for Customer, Order, and system entities
- **SMS Integration**: Complete SMS notification system with OTP verification
- **Custom UI Components**: Enhanced Swing components with modern styling

## 🚀 Quick Start

### **Prerequisites**
- Java Development Kit (JDK) 8 or higher
- XAMPP with MySQL/MariaDB
- Apache Maven 3.6+
- NetBeans IDE (recommended) or any Java IDE

### **Installation**

1. **Clone the Repository**
   ```bash
   git clone https://github.com/elyeandre/sushi-ordering-system.git
   cd sushi-ordering-system
   ```

2. **Database Setup with XAMPP phpMyAdmin**
   
   **Start XAMPP Services:**
   - Open XAMMP Control Panel
   - Start Apache and MySQL services
   - Click "Admin" next to MySQL to open phpMyAdmin

   **Import Database:**
   - In phpMyAdmin, click "New" to create a database
   - Name it `sushi_restaurant`
   - Select the database, then click "Import"
   - Choose file: `database/sushi_restaurant.sql`
   - Click "Go" to import the schema and sample data

   **Verify Installation:**
   ```sql
   -- Check if tables were created successfully
   SHOW TABLES;
   
   -- Verify sample data
   SELECT * FROM customers;
   SELECT * FROM sales;
   ```

3. **Configure Database Connection**
   ```java
   // Update SushiDBConnection.java with your XAMPP MySQL settings
   private static final String DB_URL = "jdbc:mysql://localhost:3306/sushi_restaurant";
   private static final String USER = "root";          // Default XAMPP username
   private static final String PASS = "";              // Default XAMPP password (empty)
   ```

4. **Build the Project**
   ```bash
   mvn clean compile
   ```

5. **Run the Application**
   ```bash
   mvn exec:java -Dexec.mainClass="restaurantorderingandpayment.Init"
   ```

### **Using NetBeans IDE**

1. **Open Project**
   - File → Open Project
   - Navigate to the sushi-ordering-system directory
   - Select the project folder

2. **Configure Database**
   - Ensure XAMPP MySQL is running
   - Update database credentials in `SushiDBConnection.java`

3. **Run Application**
   - Right-click on the project
   - Select "Run" or press F6
   - The application will start with the animated splash screen

## ⚙️ Configuration

### **Database Configuration**
The application uses MySQL via XAMPP for data persistence. Update the database connection settings in `SushiDBConnection.java`:

```java
public class SushiDBConnection {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sushi_restaurant";
    private static final String USER = "root";
    private static final String PASS = "";  // Default XAMPP password is empty
    
    public static Connection connectDB() {
        // Connection logic with error handling
    }
}
```

### **SMS Configuration**
Configure SMS settings for order notifications in `SendSMS.java`:

```java
// Update with your SMS service provider settings
private static final String SMS_API_URL = "your_sms_api_endpoint";
private static final String API_KEY = "your_api_key";
```

### **Menu Item Configuration**
Sushi items and prices are configured in `MainMenu.java`:

```java
// Current menu items with prices
Ama Ebi: ₱59.00
Kani: ₱39.00
Tamago: ₱39.00
Aburi: ₱49.00
Saki: ₱59.00
Maki: ₱39.00
```

## 📱 Usage Guide

### **Customer Registration & Authentication**

1. **Creating an Account**
   - Launch the application and wait for splash screen
   - Click "Register" on the login screen
   - Fill in required information:
     - Username (unique identifier)
     - Password (with strength validation)
     - Full Name (letters and spaces only)
     - Mobile Number (numbers only, for SMS)
     - Complete Address
   - Click "Register" to create account

2. **Logging In**
   - Enter registered username and password
   - Click "Login" button
   - System validates credentials against database
   - Successful login opens the main ordering interface

### **Ordering Process**

1. **Browse Menu**
   - View available sushi items with images and prices
   - Each item displays name, price, and quantity selector
   - Use spinner controls to select quantity (1-100)
   - Hover over items for visual feedback

2. **Add Items to Cart**
   - Select desired quantity using spinner
   - Click the "+" button to add item to cart
   - Visual confirmation with cart updates
   - Real-time total calculation

3. **Manage Cart**
   - View ordered items in the cart table
   - See item names, quantities, unit prices, and totals
   - Remove items using the "Remove" button
   - Clear entire cart with "Clear All" button
   - Update quantities directly in the cart

4. **Place Order**
   - Click "Order" button when ready to checkout
   - System validates cart is not empty
   - Loading screen appears during processing
   - Order details are saved to database

5. **Order Confirmation**
   - SMS confirmation sent to registered mobile number
   - OTP verification for security
   - Order success dialog with order details
   - Thank you message and order completion

### **Navigation Features**

1. **User Interface**
   - Modern rounded panel design
   - Intuitive button layouts and hover effects
   - Real-time date and time display
   - Information tooltips and help indicators

2. **Error Handling**
   - Empty cart warnings
   - Quantity limit alerts (maximum 100 per item)
   - Database connection error dialogs
   - Invalid input validation messages

3. **Loading States**
   - Splash screen with progress bar on startup
   - Order processing loading dialog
   - SMS sending progress indicator
   - Confirmation loading sequence

## 🔐 Security Notes

This is an academic prototype with basic security implementations.

### Current Security Features
- **Password Storage**: Basic password storage in database
- **Input Validation**: Phone number and name format validation
- **SQL Injection Protection**: Prepared statements for database queries
- **Duplicate Prevention**: Username uniqueness validation
- **Two-Factor Authentication**: SMS OTP verification system

### Security Limitations
- Password hashing not implemented (stores plain text)
- No session management or timeout mechanisms
- Basic input sanitization (needs enhancement)
- No role-based access control
- SMS OTP system needs production-grade implementation

### Recommended Security Improvements (For Production)
- **Implement password hashing** using bcrypt or similar
- **Add session management** with secure tokens
- **Enhance input validation** and sanitization
- **Add HTTPS/SSL** for secure communication
- **Implement rate limiting** for login attempts
- **Add audit logging** for security events
- **Secure SMS integration** with proper API authentication

## 🚀 Deployment

### **JAR Package Creation**
```bash
# Create executable JAR with dependencies
mvn clean compile assembly:single

# The JAR file will be created as:
# target/RestaurantOrderingAndPayment-1.0.0-jar-with-dependencies.jar

# Run the application
java -jar target/RestaurantOrderingAndPayment-1.0.0-jar-with-dependencies.jar
```

### **Database Deployment with XAMPP**

#### **XAMPP Setup for Production**
1. **Install XAMPP**
   - Download from Apache Friends website
   - Install with MySQL and phpMyAdmin components
   - Start Apache and MySQL services

2. **Database Import via phpMyAdmin**
   ```bash
   # Access phpMyAdmin
   http://localhost/phpMyAdmin
   
   # Create database
   CREATE DATABASE sushi_restaurant CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   
   # Import schema and data
   # Use Import feature to upload database/sushi_restaurant.sql
   ```

3. **Configure Connection**
   ```java
   // Production database settings for XAMPP
   private static final String DB_URL = "jdbc:mysql://localhost:3306/sushi_restaurant";
   private static final String USER = "root";
   private static final String PASS = ""; // XAMPP default
   ```

### **Windows Installation Package**

#### **Create Installation Directory**
```
SushiOrderingSystem-Installer/
├── sushi-ordering-system.jar
├── lib/
│   ├── mysql-connector-java-8.0.29.jar
│   └── httpclient-4.5.13.jar
├── database/
│   └── sushi_restaurant.sql
├── images/
│   └── (all UI images)
├── README.txt
├── INSTALL.bat
└── RUN.bat
```

#### **Installation Script (Windows)**
```batch
@echo off
echo Installing Sushi Ordering System...

REM Create application directory
mkdir "C:\Program Files\SushiOrderingSystem"

REM Copy application files
copy sushi-ordering-system.jar "C:\Program Files\SushiOrderingSystem\"
xcopy lib "C:\Program Files\SushiOrderingSystem\lib\" /E /I
xcopy database "C:\Program Files\SushiOrderingSystem\database\" /E /I

REM Create desktop shortcut
echo @echo off > "%USERPROFILE%\Desktop\Sushi Ordering System.bat"
echo cd "C:\Program Files\SushiOrderingSystem" >> "%USERPROFILE%\Desktop\Sushi Ordering System.bat"
echo java -jar sushi-ordering-system.jar >> "%USERPROFILE%\Desktop\Sushi Ordering System.bat"

echo Installation complete!
echo Please import database/sushi_restaurant.sql into phpMyAdmin
pause
```

### **System Requirements**

#### **Minimum Requirements**
- **Operating System**: Windows 7+ / macOS 10.12+ / Linux
- **Java Runtime**: JRE 8 or higher
- **Memory**: 512 MB RAM minimum, 1 GB recommended
- **Storage**: 100 MB free disk space
- **Database**: MySQL 5.7+ or MariaDB 10.2+ (via XAMPP)

#### **Recommended Requirements**
- **Java Runtime**: JRE 11 (LTS version)
- **Memory**: 2 GB RAM or higher
- **Storage**: 500 MB free disk space
- **Database**: MySQL 8.0+ with XAMPP latest version
- **Display**: 1024x768 minimum resolution, 1366x768 recommended

## 🤝 Contributing

We welcome contributions to improve the Sushi Ordering System! Here's how you can help:

### **Getting Started**

1. **Fork the Repository**
   ```bash
   git clone https://github.com/elyeandre/sushi-ordering-system.git
   cd sushi-ordering-system
   ```

2. **Set Up Development Environment**
   ```bash
   # Install XAMPP and start MySQL
   # Import database schema
   # Configure NetBeans IDE
   mvn clean install
   ```

3. **Create Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b bugfix/issue-description
   ```

### **Development Guidelines**

#### **Code Style**
- Follow Java naming conventions
- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Maintain consistent indentation (4 spaces)
- Keep methods focused and reasonably sized

#### **Database Changes**
- Test all database modifications
- Update schema documentation
- Ensure data integrity with foreign keys
- Test with sample data

#### **UI Development**
- Use NetBeans GUI Builder for consistency
- Follow existing design patterns
- Test on different screen resolutions
- Maintain accessibility standards

### **Contribution Types**

#### **🐛 Bug Fixes**
- Authentication and login issues
- Cart calculation problems
- Database connection errors
- UI/UX inconsistencies

#### **✨ New Features**
- Additional menu items and categories
- Enhanced SMS notification system
- Customer order history
- Admin dashboard for restaurant management
- Receipt printing functionality

#### **📚 Documentation**
- Code documentation improvements
- User manual creation
- API documentation
- Installation guides

#### **🔧 System Optimization**
- Performance improvements
- Code refactoring and optimization
- Memory usage optimization
- Database query improvements

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

### **MIT License Summary**
- ✅ Commercial use allowed
- ✅ Modification allowed
- ✅ Distribution allowed
- ✅ Private use allowed
- ❌ No liability
- ❌ No warranty
- ❗ License and copyright notice required

## 📷 Screenshots

> **Note**: This is an academic prototype demonstrating restaurant ordering system concepts. Features like payment processing, advanced security, and real-time inventory management are simplified for educational purposes.

### Application Splash Screen
![Splash Screen](https://github.com/user-attachments/assets/10abbab6-3e8f-4be4-9a98-d6979208ec3c)

*Loading screen with animated progress bar and sushi branding*

### Registration Interface
![Registration Interface](https://github.com/user-attachments/assets/fe79f7d4-3ad4-4230-ae0e-5aed0115337e)

*Secure authentication system with user registration and validation*

### Login Interface
![Login Interface](https://github.com/user-attachments/assets/9bff3231-4d2a-437b-959f-6718607cee9c)

*Secure authentication system with user login and validation*


### Main Menu Interface
![Main Menu](https://github.com/user-attachments/assets/12756946-238f-4fe2-8b8f-8d178516e3fc)

*Interactive sushi menu with quantity selection and cart management*

### Order Receipt Generator
![Order Receipt](https://github.com/user-attachments/assets/0cac8aca-dc87-462d-b6cb-e7afd939c42f)

*Professional receipt generation featuring itemized billing with quantities, unit prices, and totals. Includes complete customer information, restaurant branding, order date, payment method, and formatted layout for printing or digital delivery.* 

### SMS OTP Verification
![SMS OTP](https://github.com/user-attachments/assets/e7d5b5d9-7ae7-4084-929d-1be42eed0664)

*Two-factor authentication with OTP verification via SMS for secure orders*

---

**🍣 Built with ❤️ for Sushi Lovers and Restaurant Technology**

*"Bringing traditional Japanese cuisine into the digital age through innovative ordering technology"*

---

**📊 Database Schema Available**: Import `database/sushi_restaurant.sql` into phpMyAdmin for complete setup

**🔧 XAMPP Compatible**: Designed to work seamlessly with XAMPP MySQL environment

**📱 SMS Integration**: Complete SMS notification system with OTP verification

**🎨 Modern UI**: Custom rounded panels and interactive elements for enhanced user experience

---

[made-with-java]: https://img.shields.io/badge/Made%20with-Java-orange.svg?style=for-the-badge
[built-with-love]: https://img.shields.io/badge/Built%20with-❤️-red.svg?style=for-the-badge
[forthebadge-url]: http://forthebadge.com
[contributors-shield]: https://img.shields.io/github/contributors/elyeandre/sushi-ordering-system.svg?style=for-the-badge
[contributors-url]: https://github.com/elyeandre/sushi-ordering-system/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/elyeandre/sushi-ordering-system.svg?style=for-the-badge
[forks-url]: https://github.com/elyeandre/sushi-ordering-system/network/members
[stars-shield]: https://img.shields.io/github/stars/elyeandre/sushi-ordering-system.svg?style=for-the-badge
[stars-url]: https://github.com/elyeandre/sushi-ordering-system/stargazers
[issues-shield]: https://img.shields.io/github/issues/elyeandre/sushi-ordering-system.svg?style=for-the-badge
[issues-issues-url]: https://github.com/elyeandre/sushi-ordering-system/issues

*Last updated: September 25, 2025*