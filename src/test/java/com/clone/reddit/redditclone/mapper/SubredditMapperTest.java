package com.clone.reddit.redditclone.mapper;

import com.clone.reddit.redditclone.dto.SubredditDto;
import com.clone.reddit.redditclone.model.Post;
import com.clone.reddit.redditclone.model.Subreddit;
import com.clone.reddit.redditclone.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Subreddit Mapper Unit Tests")
public class SubredditMapperTest {

    private SubredditMapper subredditMapper;

    @BeforeEach
    public void setUp() {
        subredditMapper = Mappers.getMapper(SubredditMapper.class);
    }

    /**
     * Tests the mapSubredditToDto method by creating a Subreddit object with two posts,
     * mapping it to a SubredditDto, and asserting that the properties of the two objects match.
     */
    @Test
    @DisplayName("Test mapSubredditToDto method")
    public void testMapSubredditToDto() {
        // Create a Subreddit object.
        Subreddit subreddit = new Subreddit(1L, "Subreddit name", "Subreddit description",
                new ArrayList<>(), Instant.now(), new User());

        // Create a first Post object.
        Post post1 = new Post(1L, "Post name 1", "http://localhost:8080/api/post/1",
                "Post description 1", 0, new User(), Instant.now(), subreddit);

        // Create a second Post object.
        Post post2 = new Post(2L, "Post name 2", "http://localhost:8080/api/post/2",
                "Post description 2", 0, new User(), Instant.now(), subreddit);

        // Create a list of Post objects.
        List<Post> posts = Arrays.asList(post1, post2);

        // Assign a list of Post objects to a subreddit object.
        subreddit.setPosts(posts);

        // Map a Subreddit object to a SubredditDto object.
        SubredditDto subredditDto = subredditMapper.mapSubredditToDto(subreddit);

        // Assert.
        assertEquals(subreddit.getId(), subredditDto.getId());
        assertEquals(subreddit.getName(), subredditDto.getName());
        assertEquals(subreddit.getDescription(), subredditDto.getDescription());
        assertEquals(subreddit.getPosts().size(), subredditDto.getNumberOfPosts());
    }

    /**
     * Tests the mapDtoToSubreddit method by creating a SubredditDto object,
     * mapping it to a Subreddit, and asserting that the properties of the two objects match.
     */
    @Test
    @DisplayName("Test mapDtoToSubreddit method")
    public void testMapDtoToSubreddit() {
        // Create a SubredditDto object.
        SubredditDto subredditDto = new SubredditDto(1L, "Subreddit name", "Subreddit description", 2);

        // Map a SubredditDto object to a Subreddit object
        Subreddit subreddit = subredditMapper.mapDtoToSubreddit(subredditDto);

        // Assert.
        assertEquals(subredditDto.getId(), subreddit.getId());
        assertEquals(subredditDto.getName(), subreddit.getName());
        assertEquals(subredditDto.getDescription(), subreddit.getDescription());
        assertNull(subreddit.getPosts());
    }

    /**
     * Tests the mapSubredditToDto method with a null argument and asserts that it returns null.
     */
    @Test
    @DisplayName("Test mapSubredditToDto method with null argument")
    public void testMapSubredditToDtoWithNull() {
        // Map a Subreddit object to a SubredditDto object.
        SubredditDto subredditDto = subredditMapper.mapSubredditToDto(null);

        // Assert.
        assertNull(subredditDto);
    }

    /**
     * Tests the mapDtoToSubreddit method with a null argument and asserts that it returns null.
     */
    @Test
    @DisplayName("Test mapDtoToSubreddit method with null argument")
    public void testMapDtoToSubredditWithNull() {
        // Map a SubredditDto null object to a Subreddit object.
        Subreddit subreddit = subredditMapper.mapDtoToSubreddit(null);

        // Assert.
        assertNull(subreddit);
    }
}
