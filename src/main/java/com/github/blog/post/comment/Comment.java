package com.github.blog.post.comment;

import com.github.blog.post.Post;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Instant createdAt;
    private Boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public Comment setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }
}
