# LibrMs
Project Overview  A Library Management System implemented as a Java console application. It demonstrates core Object-Oriented Programming (OOP) principles—such as encapsulation, inheritance, and polymorphism—alongside file I/O 
Project Structure

```bash
LibrMS/
└── src/
    └── librms/
        ├── Book.java
        ├── Inventory.java
        ├── Library.java
        ├── Member.java
        ├── Transaction.java
        └── LibraryManagementSystem.java
```

Both files belong to the librms package and must reside inside a folder named librms.

## Features

1.Add/Remove Books

2.Register/Remove Members

3.Search Book/Member Information

4.Display Book and Member Names

5.Lend and Return Books

6.View Lending and Overdue Information

## Requirements

- Java JDK 8 or higher

- Command Line Terminal or Java-supported IDE (IntelliJ, Eclipse, NetBeans, etc.)

## How to Run

### Clone or Download

Clone the repository or place your .java files inside the following structure:

```
LibrMS/
└── src/
    └── librms/
        ├── Book.java
        ├── Inventory.java
        ├── Library.java
        ├── Member.java
        ├── Transaction.java
        └── LibraryManagementSystem.java
```

## Navigate to the Project Folder

```bash
cd .\src
```

## Compile the Java Files

```bash
javac librms\*.java
```

This will compile all files inside the librarymanasys package.

## Run the Program

```bash
java librms.LibraryManagementSystem
```

## Example Usage

```bash
1. Add Book
2. Register Member
3. Remove Book
4. Remove Member
5. Search Book Information
6. Search Member Information
7. Display Book Names
8. Display Member Names
9. Lend Book
10. Return Book
11. View Lending Information
12. Display Overdue Books
13. Exit

Enter the option: 1
Enter Book Name: Java Programming
Enter Author: John Doe
Book added successfully.

```

## Notes

- Ensure both Library.java and LibraryManagementSystem.java are in the same librarymanasys package directory.

- You can run the program in any IDE by setting the working directory to the project root.
