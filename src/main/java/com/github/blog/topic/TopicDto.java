package com.github.blog.topic;

public class TopicDto {
    private Long id;
    private String name;
    private String description;

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
