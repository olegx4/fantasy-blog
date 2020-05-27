package com.github.blog.post;

import com.github.blog.post.dto.command.PostCommand;
import com.github.blog.topic.Topic;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String attachment;
    private Instant dateAndTime;
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Post() {
    }

    public Post(PostCommand command) {
        this.title = command.getTitle();
        this.message = command.getMessage();
        this.attachment = command.getTitle();
        this.dateAndTime = command.getDateAndTime();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long postId) {
        this.id = postId;
    }

    public Instant getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Instant dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
