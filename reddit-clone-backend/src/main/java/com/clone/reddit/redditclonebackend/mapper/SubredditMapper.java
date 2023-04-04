package com.clone.reddit.redditclonebackend.mapper;

import com.clone.reddit.redditclonebackend.dto.SubredditDto;
import com.clone.reddit.redditclonebackend.model.Post;
import com.clone.reddit.redditclonebackend.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// Spring Boot (MapStruct) -> https://www.youtube.com/watch?v=iKUiW7Ghrps
// In this case, the @Mapper annotation is used to indicate that this
// interface is a MapStruct mapper, and the componentModel attribute
// is set to "spring" to enable Spring integration.

/**
 * Interface is defining a mapper that can be used to convert
 * between Subreddit and SubredditDto objects in a Spring Boot application.
 */
@Mapper(componentModel = "spring")
public interface SubredditMapper {

    /**
     * This method maps a Subreddit object to a SubredditDto object. It uses the @Mapping
     * annotation to specify the mapping of the numberOfPosts field, which is calculated
     * by calling the mapPosts method and passing in the list of Post objects
     * in the Subreddit object.
     * @param subreddit
     * @return
     */
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    /**
     * This is a default method that takes a list of Post objects and returns the number of
     * elements in the list. It is used by the mapSubredditToDto method to calculate
     * the numberOfPosts field in the SubredditDto.
     * @param numberOfPosts
     * @return
     */
    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    /**
     * This method maps a SubredditDto object to a Subreddit object. It uses the @InheritInverseConfiguration
     * annotation to inherit the mapping configuration from the mapSubredditToDto method, and
     * the @Mapping annotation to specify that the posts field should be ignored.
     * @param subredditDto
     * @return
     */
    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
