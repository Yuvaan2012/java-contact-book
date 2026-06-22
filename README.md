# Console Contact Management System

A lightweight, terminal-based CRUD application built in Java using Maven. This project manages a persistent database of contacts, allowing users to create, view, update, and delete entries via an interactive command-line interface.

## Features
* **Full CRUD Operations**: Create, read, update, and delete contact data seamlessly.
* **Persistent Storage**: Contact records are saved to and read from a local JSON database file.
* **Robust File Handling**: Features graceful handling of missing, empty, or corrupted data files.
* **Structured OOP Design**: Separates data modeling, business logic, and UI execution into clean modules.

## Tech Stack & Dependencies
* **Language**: Java (JDK 8 or higher)
* **Build System**: Apache Maven
* **JSON Serialization**: Google Gson (v2.10.1)

## Project Structure
```text
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   ├── Main.java         # CLI Controller & Loop
│                   ├── ContactBook.java   # JSON Data Serialization Logic
│                   └── Contact.java       # Contact Data Object Model
└── pom.xml                               # Maven Configuration File
```

## Prerequisites & Setup
Make sure you have [Java JDK](https://oracle.com) and [Maven](https://apache.org) installed on your system.

1. Clone the repository:
   ```bash
   git clone https://github.com/Yuvaan2012/java-contact-book.git
   cd java-contact-book
   ```
2. Compile and package the project:
   ```bash
   mvn clean package
   ```
3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.Main"
   ```
