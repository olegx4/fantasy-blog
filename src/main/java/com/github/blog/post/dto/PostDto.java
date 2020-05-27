package com.github.blog.post.dto;

import com.github.blog.post.Post;
import com.github.blog.topic.dto.TopicDto;

import java.time.Instant;

public class PostDto {

    private Long id;
    private String title;
    private String message;
    private String attachment;
    private Instant dateAndTime;
    private TopicDto topic;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.message = post.getMessage();
        this.attachment = post.getAttachment();
        this.dateAndTime = post.getDateAndTime();
        this.topic = new TopicDto(post.getTopic());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }

    public Instant getDateAndTime() {
        return dateAndTime;
    }

    public TopicDto getTopic() {
        return topic;
    }
}
