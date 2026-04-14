import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.setFirstName("Kyle");
        login.setLastName("Smith");
    }

    // --- assertEquals Tests ---

    @Test
    public void testUsernameCorrectlyFormatted_ReturnsCorrectMessage() {
        // The table maps a successful login with this username to the welcome message
        login.registerUser("Kyl_1", "Ch&&sec@ke99!");
        boolean isLogged = login.loginUser("Kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus(isLogged));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        // The registerUser method handles the password success scenario natively when both inputs are correct
        String result = login.registerUser("Kyl_1", "Ch&&sec@ke99!");
        assertTrue(result.contains("successfully"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        assertEquals(expected, login.registerUser("Kyl_1", "password"));
    }

    // --- assertTrue / assertFalse Tests ---

    @Test
    public void testLoginSuccessful() {
        login.registerUser("Kyl_1", "Ch&&sec@ke99!");
        assertTrue(login.loginUser("Kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("Kyl_1", "Ch&&sec@ke99!");
        assertFalse(login.loginUser("Kyl_1", "WrongPassword!"));
    }

    @Test
    public void testCheckUserNameTrue() {
        assertTrue(login.checkUserName("Kyl_1"));
    }

    @Test
    public void testCheckUserNameFalse() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberTrue() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberFalse() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}