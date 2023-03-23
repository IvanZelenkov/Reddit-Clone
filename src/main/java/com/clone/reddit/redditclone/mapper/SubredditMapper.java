package com.clone.reddit.redditclone.mapper;

import com.clone.reddit.redditclone.dto.SubredditDto;
import com.clone.reddit.redditclone.model.Post;
import com.clone.reddit.redditclone.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// Spring Boot (MapStruct) -> https://www.youtube.com/watch?v=iKUiW7Ghrps
@Mapper(componentModel = "spring")
public interface SubredditMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);
}
