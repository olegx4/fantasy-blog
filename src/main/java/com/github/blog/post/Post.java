package com.github.blog.post;

import com.github.blog.topic.Topic;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String attachment;
    private LocalDateTime dateAndTime;

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
        this.dateAndTime = LocalDateTime.now();
    }

    public Post(String title, String message, Long topicId) {
        super();
        this.title = title;
        this.message = message;
        this.topic = new Topic(topicId, "", "");
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

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
