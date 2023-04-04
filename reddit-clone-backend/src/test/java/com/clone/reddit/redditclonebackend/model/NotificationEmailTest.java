package com.clone.reddit.redditclonebackend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotificationEmailTest {

    @Test
    public void testConstructorAndGetters() {
        String subject = "Subject name";
        String recipient = "test@example.com";
        String body = "Body content";
        NotificationEmail email = new NotificationEmail(subject, recipient, body);
        assertEquals(subject, email.getSubject());
        assertEquals(recipient, email.getRecipient());
        assertEquals(body, email.getBody());
    }

    @Test
    public void testSetters() {
        NotificationEmail email = new NotificationEmail();
        String subject = "Subject name";
        String recipient = "test@example.com";
        String body = "Body content";
        email.setSubject(subject);
        email.setRecipient(recipient);
        email.setBody(body);
        assertEquals(subject, email.getSubject());
        assertEquals(recipient, email.getRecipient());
        assertEquals(body, email.getBody());
    }

    @Test
    public void testNoArgsConstructor() {
        NotificationEmail notificationEmail = new NotificationEmail();
        assertNotNull(notificationEmail);
    }
}
