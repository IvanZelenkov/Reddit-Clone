package com.clone.reddit.redditclone.service;

import com.clone.reddit.redditclone.dto.PostRequest;
import com.clone.reddit.redditclone.exceptions.SubredditNotFoundException;
import com.clone.reddit.redditclone.model.Subreddit;
import com.clone.reddit.redditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final SubredditRepository subredditRepository;

    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));

    }
}
