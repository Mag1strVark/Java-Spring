package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testCreateUserWithTwoParameters() {
        String login = "john_doe";
        String email = "john@example.com";
        User user = new User(login, email);
        Assert.assertEquals(login, user.getLogin());
        Assert.assertEquals(email, user.getEmail());
    }

    @Test
    public void testCreateUserWithNoParameters() {
        User user = new User();
        Assert.assertNull(user.getLogin());
        Assert.assertNull(user.getEmail());
    }

    @Test
    public void testSetInvalidEmail() {
        User user = new User();
        String invalidEmail = "invalid-email";
        user.setEmail(invalidEmail);
        Assert.assertNull(user.getEmail());
    }

    @Test
    public void testSetShortLogin() {
        User user = new User();
        String shortLogin = "abc";
        user.setLogin(shortLogin);
        Assert.assertNull(user.getLogin());
    }
}