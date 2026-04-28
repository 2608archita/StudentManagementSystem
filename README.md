# Student Management System

A robust console-based application to manage student records, built with Java.

## Features
- Add New Student Record
- View All Student Details
- Search Student by ID
- Update Student Information
- Delete Student Record
- Display Student Performance

## Tech Stack & Core Concepts Used
- **Language**: Java
- **OOP Principles**: 
  - **Encapsulation**: Protected properties with getters/setters in the `Student` class.
  - **Inheritance & Polymorphism**: `RegularStudent` inherits `Student` and overrides the `displayPerformance()` abstract method.
  - **Abstraction**: `Student` base class and `StudentService` interface.
- **Collections**: Data is handled using `ArrayList`.
- **Exception Handling**: A `CustomException` ensures errors (e.g., searching for a missing student) are dealt with gracefully.

## How to Compile and Run

1. Open a terminal or command prompt.
2. Navigate to the `StudentManagementSystem` directory.
3. Compile the Java files:
   ```bash
   javac model/*.java util/*.java service/*.java ui/*.java app/*.java
   ```
4. Run the application:
   ```bash
   java app.MainApp
   ```
