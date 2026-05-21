/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginapplication;

/**
 *
 * @author lab_services_student
 */
/* 
Name and Surname : Pakiso Setunku
Student Number : ST10482097
Module : Programming
Assessment : POE Part 1
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create object
        Login user = new Login();

        System.out.println("===== USER REGISTRATION =====");

        // First name
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        user.setFirstName(firstName);

        // Last name
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        user.setLastName(lastName);

        // Phone number
        System.out.print("Enter phone number: ");
        String number = input.nextLine();

        if (user.checkPhoneNumber(number)) {
            user.setPhoneNumber(number);
            System.out.println("Phone number captured successfully.");
        } else {
            System.out.println("Phone number is incorrect.");
        }

        // Username
        System.out.print("Create username: ");
        String username = input.nextLine();

        // Password
        System.out.print("Create password: ");
        String password = input.nextLine();

        // Register user
        String result = user.registerUser(username, password);
        System.out.println(result);

        // Login section
        if (result.contains("successfully")) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            // Check login
            boolean loginResult = user.loginUser(loginUsername, loginPassword);

            // Display message
            System.out.println(user.returnLoginStatus(loginResult));
        }

        input.close();
    }
}