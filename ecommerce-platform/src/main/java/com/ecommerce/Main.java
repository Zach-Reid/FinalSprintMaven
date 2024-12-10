package main.java.com.ecommerce;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Seller;
import com.ecommerce.model.Buyer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("Welcome to E-Commerce Platform");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Login
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    currentUser = UserDAO.authenticate(username, password);
                    if (currentUser != null) {
                        System.out.println("Welcome, " + currentUser.getUsername());
                        while (true) {
                            currentUser.displayMenu();
                            int menuChoice = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            if (menuChoice == 3) {
                                break; // Exit menu
                            }
                            // Handle specific actions based on role
                        }
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;
                case 2: // Register
                    System.out.print("Username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Role (buyer/seller/admin): ");
                    String role = scanner.nextLine();

                    boolean isRegistered = UserDAO.registerUser(newUsername, email, newPassword, role);
                    if (isRegistered) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed.");
                    }
                    break;
                case 3: // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


