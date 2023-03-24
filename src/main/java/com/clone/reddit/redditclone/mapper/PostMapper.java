package com.clone.reddit.redditclone.mapper;

import com.clone.reddit.redditclone.dto.PostRequest;
import com.clone.reddit.redditclone.dto.PostResponse;
import com.clone.reddit.redditclone.model.Post;
import com.clone.reddit.redditclone.model.Subreddit;
import com.clone.reddit.redditclone.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
