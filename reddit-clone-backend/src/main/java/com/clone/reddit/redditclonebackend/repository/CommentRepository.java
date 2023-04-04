package com.clone.reddit.redditclonebackend.repository;

import com.clone.reddit.redditclonebackend.model.Comment;
import com.clone.reddit.redditclonebackend.model.Post;
import com.clone.reddit.redditclonebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
