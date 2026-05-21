package com.mycompany.loginapplication;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */

// Login class
public class Login {

    // Variables to store user details
    String usernameStored;
    String passwordStored;
    String firstName;
    String lastName;
    String phoneNumber;

    // Method to save first name
    public void setFirstName(String name) {
        firstName = name;
    }

    // Method to save last name
    public void setLastName(String surname) {
        lastName = surname;
    }

    // Method to save phone number
    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }

    // Check if username is correct
    public boolean checkUsername(String username) {

        // Username must contain "_" and be 5 characters or less
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Check if password is correct
    public boolean checkPassword(String password) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // Password must be at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Loop through password characters
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            // Check for uppercase letter
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            }

            // Check for number
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }

            // Check for special character
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        // Password is valid only if all are true
        if (hasCapital && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    // Check phone number
    public boolean checkPhoneNumber(String number) {

        // Must start with +27
        if (number.startsWith("+27") && number.length() >= 12) {
            return true;
        } else {
            return false;
        }
    }

    // Register user
    public String registerUser(String username, String password) {

        // Check username
        if (checkUsername(username) == false) {
            return "Username is incorrect. It must contain '_' and be 5 characters or less.";
        }

        // Check password
        if (checkPassword(password) == false) {
            return "Password is incorrect. It must have 8 characters, a capital letter, a number and a special character.";
        }

        // Save details
        usernameStored = username;
        passwordStored = password;

        return "User registered successfully.";
    }

    // Login user
    public boolean loginUser(String username, String password) {

        // Check if entered details match saved details
        if (username.equals(usernameStored) && password.equals(passwordStored)) {
            return true;
        } else {
            return false;
        }
    }

    // Return login message
    public String returnLoginStatus(boolean loggedIn) {

        if (loggedIn == true) {
            return "Welcome " + firstName + " " + lastName + ". Good to see you again.";
        } else {
            return "Username or password is incorrect.";
        }
    }
}