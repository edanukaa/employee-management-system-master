package com.ems.ui;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

import java.util.Scanner;

public class EmployeeUI {

    private final EmployeeService employeeService = new EmployeeService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        boolean running = true;

        while (running) {
            System.out.println("""
             --- EMPLOYEE MENU ---
            1. Add Employee
            2. List Employees
            3. View Employee by ID
            4. Edit Employee (Admin only)
            5. Delete Employee
            0. Back
            """);


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> listEmployees();
                case 3 -> viewEmployee();
                case 4 -> editEmployee();
                case 5 -> deleteEmployee();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }

        }
    }

    private void addEmployee() {
        System.out.print("First name: ");
        String fn = scanner.nextLine();

        System.out.print("Last name: ");
        String ln = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Department ID: ");
        int depId = scanner.nextInt();

        employeeService.addEmployee(
                new Employee(0, fn, ln, email, salary, depId)
        );

        System.out.println("Employee added successfully.");
    }

    private void listEmployees() {
        employeeService.getAllEmployees()
                .forEach(e ->
                        System.out.println(
                                e.getEmployeeId() + " | " +
                                        e.getFirstName() + " " +
                                        e.getLastName()
                        )
                );
    }

    private void viewEmployee() {
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();

        Employee e = employeeService.getEmployeeById(id);

        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("""
        --- EMPLOYEE DETAILS ---
        ID: %d
        Name: %s %s
        Email: %s
        Salary: %.2f
        Department ID: %d
        """.formatted(
                e.getEmployeeId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getSalary(),
                e.getDepartmentId()
        ));
    }
    private void editEmployee() {
        int roleId = AuthUI.getLoggedInUser().getRoleId();

        System.out.print("Employee ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee e = employeeService.getEmployeeById(id);

        if (e == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("New first name: ");
        e.setFirstName(scanner.nextLine());

        System.out.print("New last name: ");
        e.setLastName(scanner.nextLine());

        System.out.print("New email: ");
        e.setEmail(scanner.nextLine());

        System.out.print("New salary: ");
        e.setSalary(scanner.nextDouble());

        System.out.print("New department ID: ");
        e.setDepartmentId(scanner.nextInt());

        employeeService.updateEmployee(e, roleId);
        System.out.println("Employee updated successfully.");
    }


    private void deleteEmployee() {
        int roleId = AuthUI.getLoggedInUser().getRoleId();

        System.out.print("Employee ID: ");
        int id = scanner.nextInt();

        employeeService.deleteEmployee(id, roleId);
        System.out.println("Employee deleted.");
    }
}
