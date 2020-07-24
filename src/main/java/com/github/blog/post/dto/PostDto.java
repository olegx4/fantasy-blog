package com.github.blog.post.dto;

import com.github.blog.post.Post;
import com.github.blog.post.comment.dto.CommentDto;
import com.github.blog.topic.dto.TopicDto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

    private final Long id;
    private final String title;
    private final String message;
    private final String attachment;
    private final Instant dateAndTime;
    private final TopicDto topic;

    public List<CommentDto> getComments() {
        return comments;
    }

    private final List<CommentDto> comments;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.message = post.getMessage();
        this.attachment = post.getAttachment();
        this.dateAndTime = post.getDateAndTime();
        this.topic = new TopicDto(post.getTopic());
        this.comments = post.getComments()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
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
