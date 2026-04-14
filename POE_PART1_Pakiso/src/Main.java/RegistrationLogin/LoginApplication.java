/*Name and Surname : Pakiso Setunku
    Student number : ST10482097
    Module name : Programming
    Module code : PROG5121
    Assessment type : POE Part 1 
    Due Date : 14 April 2026
    Lecturer's Name : Mr. Rikhotso Simon
    */
/*References: 
  Oracle. (n.d.) Lesson: Regular Expressions. Oracle Java Tutorials.
  Oracle. (n.d.) Pattern (Java SE 21). Oracle Documentation.
  JUnit Team. (n.d.) JUnit 5 User Guide and Assertions. JUnit.
     */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("--- USER REGISTRATION ---");
        
        System.out.print("Enter First Name: ");
        loginSystem.setFirstName(scanner.nextLine());
        
        System.out.print("Enter Last Name: ");
        loginSystem.setLastName(scanner.nextLine());
        
        // Loop until a valid cell number is entered
        String cellResult = "";
        while (true) {
            System.out.print("Enter Cell Phone Number (e.g., +27838968976): ");
            String cellInput = scanner.nextLine();
            if (loginSystem.checkCellPhoneNumber(cellInput)) {
                loginSystem.setCellPhoneNumber(cellInput);
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        System.out.print("Enter a Username (max 5 chars, must contain '_'): ");
        String usernameInput = scanner.nextLine();
        
        System.out.print("Enter a Password (min 8 chars, 1 uppercase, 1 number, 1 special char): ");
        String passwordInput = scanner.nextLine();
        
        // Attempt Registration
        String regStatus = loginSystem.registerUser(usernameInput, passwordInput);
        System.out.println(regStatus);

        // If registration was successful, proceed to login
        if (regStatus.contains("successfully")) {
            System.out.println("\n--- USER LOGIN ---");
            System.out.print("Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.print("Password: ");
            String loginPass = scanner.nextLine();
            
            boolean isLoggedIn = loginSystem.loginUser(loginUser, loginPass);
            System.out.println(loginSystem.returnLoginStatus(isLoggedIn));
        }
        
        scanner.close();
    }
}