package com.github.blog.post.comment.dto.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class CommentCommand {

    @NotBlank
    private String text;
    @NotNull
    private Instant dateAndTime;

    public String getText() {
        return text;
    }

    public CommentCommand setText(String text) {
        this.text = text;
        return this;
    }

    public Instant getDateAndTime() {
        return dateAndTime;
    }

    public CommentCommand setDateAndTime(Instant dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }
}
