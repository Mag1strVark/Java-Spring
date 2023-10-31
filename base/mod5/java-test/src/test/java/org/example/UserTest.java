package org.example;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class UserTest {

    @Test
    @DisplayName("Проверка создания объекта с двумя параметрами")
    public void test1() {
        String login = "username";
        String email = "test@example.com";
        User user = new User(login, email);
        Assert.assertEquals(login, user.getLogin());
        Assert.assertEquals(email, user.getEmail());
    }

    @Test
    @DisplayName("Проверка установка значений")
    public void test2() {
        User user = new User();
        Assert.assertNull(user.getLogin());
        Assert.assertNull(user.getEmail());
    }

    @Test
    @DisplayName("Установка Email")
    public void test3() {
        User user = new User();
        String invalidEmail = "invalid_email";
        user.setEmail(invalidEmail);
        Assert.assertNull(user.getEmail());
    }

    @Test
    @DisplayName("Установка Логина")
    public void test4() {
        User user = new User();
        String shortLogin = "abc";
        user.setLogin(shortLogin);
        Assert.assertNull(user.getLogin());
    }
}
