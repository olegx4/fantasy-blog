package com.github.blog.post.dto;

import com.github.blog.post.Post;
import com.github.blog.topic.dto.TopicDto;

import java.time.LocalDateTime;

public class PostDto {
    private String title;
    private String message;
    private String attachment;
    private LocalDateTime dateAndTime;
    private TopicDto topic;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.message = post.getMessage();
        this.attachment = post.getAttachment();
        this.dateAndTime = post.getDateAndTime();
        this.topic = new TopicDto(post.getTopic());
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

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public TopicDto getTopic() {
        return topic;
    }
}
