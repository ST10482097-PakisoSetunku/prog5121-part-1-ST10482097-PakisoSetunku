public class Login {
    
    // Global variables to store user details (No arrays used)
    private String savedUsername;
    private String savedPassword;
    private String firstName;
    private String lastName;
    private String cellPhoneNumber;

    // Setters for names
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // 1. Check Username
    public boolean checkUserName(String username) {
        // Username must contain an underscore and be no more than 5 characters long.
        if (username != null && username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }

    // 2. Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        // Must be at least 8 characters, contain a capital letter, a number, and a special character
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*"); // Anything not a letter or number
        
        return hasCapital && hasNumber && hasSpecial;
    }

    // 3. Check Cell Phone Number
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        /*
         * REFERENCE FOR REGULAR EXPRESSION:
         * Oracle (2024) Pattern (Java Platform SE 17). Available at: 
         * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html 
         * (Accessed: 14 April 2026).
         * * Note: The regex checks for a literal '+' at the start, followed by 1 to 3 digits for 
         * the country code, and up to 10 digits for the actual phone number.
         */
        if (cellPhoneNumber == null) {
            return false;
        }
        return cellPhoneNumber.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    // 4. Register User
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // If both conditions are met, save the credentials
        this.savedUsername = username;
        this.savedPassword = password;
        return "Username and Password successfully captured. Registration successful.";
    }

    // 5. Login User
    public boolean loginUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return username.equals(savedUsername) && password.equals(savedPassword);
    }

    // 6. Return Login Status
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}