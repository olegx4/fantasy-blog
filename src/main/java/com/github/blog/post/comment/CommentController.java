package com.github.blog.post.comment;

import com.github.blog.post.comment.dto.CommentDto;
import com.github.blog.post.comment.dto.command.CommentCommand;
import com.github.blog.post.comment.dto.command.CommentUpdateCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CommentDto> addComment(@PathVariable Long postId, @Valid @RequestBody CommentCommand command) {
        return new ResponseEntity<>(commentService.addComment(postId, command), HttpStatus.CREATED);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id,
                                                    @Valid @RequestBody CommentUpdateCommand command) {
        return ResponseEntity.ok(commentService.updateComment(id, command));
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{postId}/comments")
    public ResponseEntity<Void> deleteCommentByPostId(@PathVariable Long postId) {
        commentService.deletePostComments(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
