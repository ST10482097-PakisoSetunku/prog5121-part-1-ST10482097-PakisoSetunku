import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kylie", "Mokoena", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.checkUserName());
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                login.checkUserNameMessage());
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkPasswordComplexity());
        assertEquals("Password successfully captured.", login.checkPasswordComplexityMessage());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "password", "+27838968976");
        assertFalse(login.checkPasswordComplexity());
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                login.checkPasswordComplexityMessage());
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.checkCellPhoneNumber());
        assertEquals("Cell phone number successfully added.", login.checkCellPhoneNumberMessage());
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(login.checkCellPhoneNumber());
        assertEquals("Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.",
                login.checkCellPhoneNumberMessage());
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("Kyl_1", "Ch&&sec@ke99!"));
        assertEquals("Welcome Kylie, Mokoena it is great to see you.", login.returnLoginStatus());
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("Kylie", "Mokoena", "Kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wrong", "wrong"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus());
    }
}
