package com.clone.reddit.redditclone.repository;

import com.clone.reddit.redditclone.model.Post;
import com.clone.reddit.redditclone.model.User;
import com.clone.reddit.redditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
