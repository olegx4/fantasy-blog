package com.github.blog.post.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/posts/comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @GetMapping("/posts/comments/{id}")
    public ResponseEntity<CommentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getById(id));
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable Long postId, @Valid @RequestBody CommentCommand command) {
        return new ResponseEntity<>(commentService.addComment(postId, command), HttpStatus.CREATED);
    }

    @PutMapping("/posts/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id,
                                                    @Valid @RequestBody CommentUpdateCommand command) {
        return ResponseEntity.ok(commentService.updateComment(id, command));
    }

    @DeleteMapping("/posts/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> deleteCommentByPostId(@PathVariable Long postId) {
        commentService.deletePostComments(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
