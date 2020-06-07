package com.github.blog.post.comment.dto;

import com.github.blog.post.comment.Comment;

import java.time.Instant;

public class CommentDto {
    private Long id;
    private String text;
    private Instant createdAt;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
        this.createdAt = comment.getCreatedAt();
    }
}
