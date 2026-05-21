/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
Assessment : POE Part 2
*/
import java.util.Scanner;

public class LoginApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Login object
        Login user = new Login();

        //  REGISTRATION 
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
        String phoneNumber = input.nextLine();

        if (user.checkPhoneNumber(phoneNumber)) {

            user.setPhoneNumber(phoneNumber);
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
        String registerResult = user.registerUser(username, password);

        System.out.println(registerResult);

        // LOGIN 
        if (registerResult.contains("successfully")) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            // Check login
            boolean loggedIn = user.loginUser(loginUsername, loginPassword);

            // Display login message
            System.out.println(user.returnLoginStatus(loggedIn));

            // QUICKCHAT
            if (loggedIn == true) {

                System.out.println("\nWelcome to QuickChat.");

                boolean running = true;

                int messageCounter = 0;

                // Menu loop
                while (running == true) {

                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Show Sent Messages");
                    System.out.println("3. Quit");

                    System.out.print("Choose option: ");

                    int option = input.nextInt();
                    input.nextLine();

                    // SEND MESSAGES
                    if (option == 1) {

                        System.out.print("How many messages do you want to send? ");
                        int amount = input.nextInt();
                        input.nextLine();

                        // Loop through messages
                        for (int i = 0; i < amount; i++) {

                            messageCounter++;

                            System.out.println("\n===== MESSAGE " + messageCounter + " =====");

                            // Recipient
                            System.out.print("Enter recipient number: ");
                            String recipient = input.nextLine();

                            // Message text
                            System.out.print("Enter message: ");
                            String text = input.nextLine();

                            // Create message object
                            Message message = new Message(messageCounter, recipient, text);

                            // Validate recipient
                            System.out.println(message.checkRecipientCell());

                            // Validate message length
                            if (message.checkMessageLength()) {

                                System.out.println("Message captured successfully.");

                            } else {

                                System.out.println("Message exceeds 250 characters.");
                            }

                            // Action menu
                            System.out.println("\n1 - Send Message");
                            System.out.println("2 - Store Message");
                            System.out.println("0 - Delete Message");

                            System.out.print("Choose option: ");

                            int action = input.nextInt();
                            input.nextLine();

                            // Process action
                            String result = message.sentMessage(action);

                            System.out.println(result);

                            // Display details
                            if (action == 1 || action == 2) {

                                System.out.println("\n===== MESSAGE DETAILS =====");

                                System.out.println(message.printMessages());
                            }
                        }

                        // Display total messages
                        System.out.println("\nTotal Messages Sent: " + Message.returnTotalMessages());
                    }

                    // SHOW MESSAGES
                    else if (option == 2) {

                        System.out.println("Coming Soon.");
                    }

                    // QUIT
                    else if (option == 3) {

                        System.out.println("Goodbye.");

                        running = false;
                    }

                    // INVALID OPTION
                    else {

                        System.out.println("Invalid option.");
                    }
                }
            }
        }

        input.close();
    }
}