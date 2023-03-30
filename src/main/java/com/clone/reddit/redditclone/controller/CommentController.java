package com.clone.reddit.redditclone.controller;

import com.clone.reddit.redditclone.dto.CommentDto;
import com.clone.reddit.redditclone.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(params = "postId")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPost(@RequestParam Long postId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.getAllCommentsByPost(postId));
    }

    @GetMapping(params = "username")
    public ResponseEntity<List<CommentDto>> getAllCommentsByUser(@RequestParam String username){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.getAllCommentsByUser(username));
    }
}
