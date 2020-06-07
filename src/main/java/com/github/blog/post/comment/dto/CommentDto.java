package com.github.blog.post.comment.dto;

import com.github.blog.post.comment.Comment;

import java.time.Instant;

public class CommentDto {
    private final Long id;
    private final String text;
    private final Instant createdAt;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
        this.createdAt = comment.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
