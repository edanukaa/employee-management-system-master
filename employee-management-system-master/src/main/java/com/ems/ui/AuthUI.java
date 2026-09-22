package com.ems.ui;

import com.ems.model.User;
import com.ems.service.AuthService;

import java.util.Scanner;

public class AuthUI {

    private final AuthService authService = new AuthService();
    private final Scanner scanner = new Scanner(System.in);

    private static User loggedInUser;

    public boolean login() {
        try {
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            loggedInUser = authService.login(username, password);

            if (loggedInUser == null) {
                System.out.println("Invalid credentials.");
                return false;
            }

            System.out.println("Login successful!");
            return true;

        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }
}
