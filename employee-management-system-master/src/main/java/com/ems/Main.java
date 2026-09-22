package com.ems;

import com.ems.ui.AuthUI;
import com.ems.ui.EmployeeUI;
import com.ems.ui.DepartmentUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthUI authUI = new AuthUI();
        EmployeeUI employeeUI = new EmployeeUI();
        DepartmentUI departmentUI = new DepartmentUI();


        if (!authUI.login()) {
            System.out.println("Login failed. Exiting application.");
            return;
        }

        boolean running = true;

        while (running) {
            System.out.println("""
                === EMPLOYEE MANAGEMENT SYSTEM ===
                1. Employee Management
                2. Department Management
                0. Exit
                Choose option:
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> employeeUI.start();
                case 2 -> departmentUI.start();
                case 0 -> running = false;
                default -> System.out.println("Invalid option!");
            }
        }

        System.out.println("Application closed.");
    }
}
