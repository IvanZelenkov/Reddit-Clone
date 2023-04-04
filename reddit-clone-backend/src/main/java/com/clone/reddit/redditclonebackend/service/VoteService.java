package com.clone.reddit.redditclonebackend.service;

import com.clone.reddit.redditclonebackend.dto.VoteDto;
import com.clone.reddit.redditclonebackend.exceptions.PostNotFoundException;
import com.clone.reddit.redditclonebackend.exceptions.SpringRedditException;
import com.clone.reddit.redditclonebackend.model.Post;
import com.clone.reddit.redditclonebackend.model.Vote;
import com.clone.reddit.redditclonebackend.model.VoteType;
import com.clone.reddit.redditclonebackend.repository.PostRepository;
import com.clone.reddit.redditclonebackend.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final PostRepository postRepository;
    private final AuthService authService;

    @Transactional
    public void vote(VoteDto voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + voteDto.getPostId()));
        // Get the latest vote
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());

        if (voteByPostAndUser.isPresent() && voteByPostAndUser.get().getVoteType().equals(voteDto.getVoteType()))
            throw new SpringRedditException("You have already " + voteDto.getVoteType() + "'d for this post");
        else if (VoteType.UPVOTE.equals(voteDto.getVoteType()))
            post.setVoteCount(post.getVoteCount() + 1);
        else
            post.setVoteCount(post.getVoteCount() - 1);

        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    private Vote mapToVote(VoteDto voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
