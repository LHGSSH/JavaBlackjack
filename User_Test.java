import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class User_Test
{
    User newUser = new User("testName", "testPassword");

    @Test
    void loginCheck()
    {
        assertTrue(newUser.loginCheck("testName", "testPassword"));
        assertFalse(newUser.loginCheck("testName", "wrongPassword"));
    }
    @Test
    void changePassword()
    {
        assertTrue(newUser.changePassword("testName", "testPassword", "newTestPass"));
        assertFalse(newUser.changePassword("testName", "wrongPassword", "newTestPass"));
    }
    @Test
    void encrypt()
    {
        assertNotEquals("testPassword", newUser.encrypt("testPassword"));
    }
    @Test
    void decrypt()
    {
        assertEquals("testPassword", newUser.decrypt(newUser.encrypt("testPassword")));
    }
}