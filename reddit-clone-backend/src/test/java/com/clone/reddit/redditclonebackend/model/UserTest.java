package com.clone.reddit.redditclonebackend.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        Long userId = 1L;
        String username = "Test_User";
        String password = "password123";
        String email = "test@example.com";
        Instant created = Instant.now();
        boolean enabled = true;

        User user = new User(userId, username, password, email, created, enabled);

        assertEquals(userId, user.getUserId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(created, user.getCreated());
        assertTrue(user.isEnabled());
    }

    @Test
    public void testSetters() {
        User user = new User();

        Long userId = 1L;
        String username = "Test_User";
        String password = "password123";
        String email = "test@example.com";
        Instant created = Instant.now();
        boolean enabled = true;

        user.setUserId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCreated(created);
        user.setEnabled(enabled);

        assertEquals(userId, user.getUserId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(created, user.getCreated());
        assertTrue(user.isEnabled());
    }

    @Test
    public void testNoArgsConstructor() {
        User user = new User();
        assertNotNull(user);
    }
}
