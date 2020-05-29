package com.github.blog.post.comment;

import com.github.blog.topic.Topic;

import java.time.Instant;
import java.util.Set;

public class Comment {

    private Long id;
    private String text;
    private Instant createdAt;
    private Topic topic;
    private Set<Comment> comment;
    private Boolean isDeleted = false;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Topic getTopic() {
        return topic;
    }

    public Comment setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public Comment setComment(Set<Comment> comment) {
        this.comment = comment;
        return this;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public Comment setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }
}
