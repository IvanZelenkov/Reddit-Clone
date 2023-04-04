package com.clone.reddit.redditclonebackend.repository;

import com.clone.reddit.redditclonebackend.model.Post;
import com.clone.reddit.redditclonebackend.model.User;
import com.clone.reddit.redditclonebackend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
