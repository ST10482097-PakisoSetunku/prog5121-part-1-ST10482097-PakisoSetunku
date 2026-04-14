import java.util.regex.Pattern;

public class Login {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;
    private boolean loggedIn;

    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.loggedIn = false;
    }

    public boolean checkUserName() {
        return username != null && username.length() <= 5 && username.contains("_");
    }

    public String checkUserNameMessage() {
        if (checkUserName()) {
            return "Username successfully captured.";
        }
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapitalLetter = Pattern.compile(".*[A-Z].*").matcher(password).matches();
        boolean hasNumber = Pattern.compile(".*\\d.*").matcher(password).matches();
        boolean hasSpecialCharacter = Pattern.compile(".*[^A-Za-z0-9].*").matcher(password).matches();

        return hasCapitalLetter && hasNumber && hasSpecialCharacter;
    }

    public String checkPasswordComplexityMessage() {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        }
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber != null && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String checkCellPhoneNumberMessage() {
        if (checkCellPhoneNumber()) {
            return "Cell phone number successfully added.";
        }
        return "Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.";
    }

    public String registerUser() {
        if (!checkUserName()) {
            return checkUserNameMessage();
        }

        if (!checkPasswordComplexity()) {
            return checkPasswordComplexityMessage();
        }

        if (!checkCellPhoneNumber()) {
            return checkCellPhoneNumberMessage();
        }

        return "Username successfully captured.\n"
                + "Password successfully captured.\n"
                + "Cell phone number successfully added.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        loggedIn = username != null && password != null
                && username.equals(enteredUsername)
                && password.equals(enteredPassword);
        return loggedIn;
    }

    public String returnLoginStatus() {
        if (loggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you.";
        }
        return "Username or password incorrect, please try again.";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
