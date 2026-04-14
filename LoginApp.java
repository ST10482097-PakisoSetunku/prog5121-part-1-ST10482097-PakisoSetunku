import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Read the full task carefully before starting.");
        System.out.println("--- Registration ---");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        Login login = new Login(firstName, lastName, username, password, cellPhoneNumber);

        System.out.println(login.registerUser());

        System.out.println();
        System.out.println("--- Login ---");

        System.out.print("Enter username to log in: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password to log in: ");
        String loginPassword = scanner.nextLine();

        login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus());

        scanner.close();
    }
}
