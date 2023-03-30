package com.clone.reddit.redditclone.service;

import com.clone.reddit.redditclone.dto.VoteDto;
import com.clone.reddit.redditclone.exceptions.PostNotFoundException;
import com.clone.reddit.redditclone.exceptions.SpringRedditException;
import com.clone.reddit.redditclone.model.Post;
import com.clone.reddit.redditclone.model.Vote;
import com.clone.reddit.redditclone.model.VoteType;
import com.clone.reddit.redditclone.repository.PostRepository;
import com.clone.reddit.redditclone.repository.VoteRepository;
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
