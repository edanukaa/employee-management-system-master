# Employee Management System

## Description
This project is a backend Employee Management System developed in Java, using a database-first approach with Microsoft SQL Server (MSSQL). The application manages employee data and demonstrates how to integrate a Java application with a relational database.

## Technologies Used
- Java
- Microsoft SQL Server (MSSQL)
- JDBC (Java Database Connectivity)

## Features
- Add new employees
- View employee records
- Update employee information
- Delete employees from the system
- Database-driven logic (SQL-first approach)

## Database Design
The database was designed and implemented in SQL Server Management Studio (SSMS). It includes structured tables for storing employee data and supports CRUD operations.

## How It Works
The application connects to the MSSQL database using JDBC. SQL queries are used to interact with the database and perform operations such as inserting, updating, retrieving, and deleting records.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/dinazejneli/employee-management-system.git
2. Open the project in your Java IDE (e.g., IntelliJ or Eclipse)
3. Set up your MSSQL database in SQL Server Management Studio
4. Update database connection details in the code (username, password, URL)
5. Run the application
   
## What I Learned
- Connecting Java applications to a SQL database using JDBC
- Designing and managing relational databases in MSSQL
- Implementing CRUD operations
- Working with a database-first development approach

## Future Improvements
- Add a frontend (e.g., Vue.js)
- Improve validation and error handling
- Implement authentication and user roles
