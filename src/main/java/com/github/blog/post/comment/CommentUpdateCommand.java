package com.github.blog.post.comment;

import javax.validation.constraints.NotBlank;

public class CommentUpdateCommand {
    @NotBlank
    private String text;

    public String getText() {
        return text;
    }

    public CommentUpdateCommand setText(String text) {
        this.text = text;
        return this;
    }
}
