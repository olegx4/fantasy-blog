package com.github.blog.post.comment;

import com.github.blog.post.comment.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts/comments")
public class CommentController {
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentController(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentsRepository
                .findAll()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList()));
    }
}
