package com.github.blog.topic.dto;

import com.github.blog.topic.Topic;

public class TopicDto {
    private final Long id;
    private final String name;
    private final String description;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.name = topic.getName();
        this.description = topic.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
