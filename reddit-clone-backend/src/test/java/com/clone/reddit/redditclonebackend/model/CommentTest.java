package com.clone.reddit.redditclonebackend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommentTest {
    private Comment comment;
    private Long id;
    private String text;
    private Post post;
    private Instant createdDate;
    private User user;

    @BeforeEach
    public void setUp() {
        id = 1L;
        text = "This is a test comment.";
        post = new Post();
        createdDate = Instant.now();
        user = new User();
        comment = new Comment(id, text, post, createdDate, user);
    }

    @Test
    public void testId() {
        assertEquals(id, comment.getId());
    }

    @Test
    public void testText() {
        assertEquals(text, comment.getText());
    }

    @Test
    public void testPost() {
        assertEquals(post, comment.getPost());
    }

    @Test
    public void testCreatedDate() {
        assertEquals(createdDate, comment.getCreatedDate());
    }

    @Test
    public void testUser() {
        assertEquals(user, comment.getUser());
    }

    @Test
    public void testNoArgsConstructor() {
        Comment comment = new Comment();
        assertNotNull(comment);
    }
}
