package com.clone.reddit.redditclonebackend.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostTest {

    @Test
    public void testCreatePost() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("Test_User");
        user.setEmail("test@example.com");
        user.setPassword("password123");
        user.setEnabled(true);

        Subreddit subreddit = new Subreddit();
        subreddit.setId(1L);
        subreddit.setName("Subreddit name");
        subreddit.setDescription("Subreddit description");

        Instant now = Instant.now();

        Post post = Post.builder()
                .postId(1L)
                .postName("Post name")
                .url("http://localhost:8080/api/post/1")
                .description("Post description")
                .voteCount(0)
                .user(user)
                .createdDate(now)
                .subreddit(subreddit)
                .build();

        assertNotNull(post);
        assertEquals(1L, post.getPostId());
        assertEquals("Post name", post.getPostName());
        assertEquals("http://localhost:8080/api/post/1", post.getUrl());
        assertEquals("Post description", post.getDescription());
        assertEquals(0, post.getVoteCount());
        assertEquals(user, post.getUser());
        assertEquals(now, post.getCreatedDate());
        assertEquals(subreddit, post.getSubreddit());
    }

    @Test
    public void testNoArgsConstructor() {
        Post post = new Post();
        assertNotNull(post);
    }
}
