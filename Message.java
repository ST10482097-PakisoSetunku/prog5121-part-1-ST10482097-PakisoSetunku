/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapplication;

/**
 *
 * @author lab_services_student
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

public class Message {

    // Variables
    String messageID;
    int messageNumber;
    String recipient;
    String messageText;
    String messageHash;

    // Static variable for total messages
    static int totalMessages = 0;

    // Constructor
    public Message(int number, String recipientCell, String text) {

        messageNumber = number;
        recipient = recipientCell;
        messageText = text;

        messageID = createMessageID();
        messageHash = createMessageHash();
    }

    // Create random message ID
    public String createMessageID() {

        Random random = new Random();

        int number1 = random.nextInt(99999);
        int number2 = random.nextInt(99999);

        String id = number1 + "" + number2;

        return id;
    }

    // Check message ID length
    public boolean checkMessageID() {

        if (messageID.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    // Check recipient number
    public String checkRecipientCell() {

        if (recipient.startsWith("+") && recipient.length() <= 10) {
            return "Cell number is correct.";
        } else {
            return "Cell number is incorrect.";
        }
    }

    // Check message length
    public boolean checkMessageLength() {

        if (messageText.length() <= 250) {
            return true;
        } else {
            return false;
        }
    }

    // Create message hash
    public String createMessageHash() {

        String firstTwoNumbers = messageID.substring(0, 2);

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String hash = firstTwoNumbers + ":" + messageNumber + ":" + firstWord + lastWord;

        return hash.toUpperCase();
    }

    // Send, store or delete message
    public String sentMessage(int choice) {

        if (choice == 1) {

            totalMessages++;

            return "Message sent successfully.";

        } else if (choice == 2) {

            totalMessages++;

            storeMessage();

            return "Message stored successfully.";

        } else if (choice == 0) {

            return "Message deleted.";

        } else {

            return "Invalid option.";
        }
    }

    // Print message details
    public String printMessages() {

        String details = "";

        details = details + "Message ID: " + messageID + "\n";
        details = details + "Message Hash: " + messageHash + "\n";
        details = details + "Recipient: " + recipient + "\n";
        details = details + "Message: " + messageText;

        return details;
    }

    // Return total messages
    public static int returnTotalMessages() {

        return totalMessages;
    }

    // Store message in file
    public void storeMessage() {

        try {

            FileWriter file = new FileWriter("messages.txt", true);

            PrintWriter writer = new PrintWriter(file);

            writer.println("Message ID: " + messageID);
            writer.println("Message Hash: " + messageHash);
            writer.println("Recipient: " + recipient);
            writer.println("Message: " + messageText);
            writer.println("--------------------------------");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving message.");
        }
    }
}