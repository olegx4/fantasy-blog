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

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long commentId,
                                                    @Valid @RequestBody CommentUpdateCommand command) {
        return ResponseEntity.ok(commentService.updateComment(commentId, command));
    }
}
