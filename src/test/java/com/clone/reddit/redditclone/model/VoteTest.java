package com.clone.reddit.redditclone.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoteTest {

    @Test
    @DisplayName("Test creating Vote object with all arguments")
    public void testCreatingVoteWithAllArguments() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("Test_User");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        Post post = new Post();
        post.setPostId(1L);
        post.setPostName("Post name");
        post.setUrl("http://localhost:8080/api/post/1");
        post.setDescription("Post description");

        Vote vote = new Vote(1L, VoteType.UPVOTE, post, user);
        assertEquals(1L, vote.getVoteId());
        assertEquals(VoteType.UPVOTE, vote.getVoteType());
        assertEquals(post, vote.getPost());
        assertEquals(user, vote.getUser());
    }

    @Test
    @DisplayName("Test setting Vote properties")
    public void testSettingVoteProperties() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("Test_User");
        user.setPassword("password123");
        user.setEmail("test@example.com");

        Post post = new Post();
        post.setPostId(1L);
        post.setPostName("Post name");
        post.setUrl("http://localhost:8080/api/post/1");
        post.setDescription("Post description");

        Vote vote = new Vote();
        vote.setVoteId(1L);
        vote.setVoteType(VoteType.DOWNVOTE);
        vote.setPost(post);
        vote.setUser(user);

        assertEquals(1L, vote.getVoteId());
        assertEquals(VoteType.DOWNVOTE, vote.getVoteType());
        assertEquals(post, vote.getPost());
        assertEquals(user, vote.getUser());
    }

    @Test
    @DisplayName("Test creating Vote object with no arguments")
    public void testCreatingVoteWithNoArguments() {
        Vote vote = new Vote();
        assertNull(vote.getVoteId());
        assertNull(vote.getVoteType());
        assertNull(vote.getPost());
        assertNull(vote.getUser());
    }
}
