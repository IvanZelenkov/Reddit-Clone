package com.clone.reddit.redditclonebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditCloneBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditCloneBackendApplication.class, args);
    }

}
