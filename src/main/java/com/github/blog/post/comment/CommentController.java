package com.github.blog.post.comment;

import com.github.blog.post.comment.dto.CommentDto;
import com.github.blog.post.comment.dto.command.CommentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long postId, CommentCommand command) {
        return new ResponseEntity<>(commentService.addComment(postId, command), HttpStatus.CREATED);
    }
}
