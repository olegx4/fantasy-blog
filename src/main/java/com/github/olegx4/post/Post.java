package com.github.olegx4.post;

import com.github.olegx4.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    private String postId;
    private String title;
    private String message;
    private String attachment;
    private LocalDate date;

    @ManyToOne
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    public Post() {
        this.date = LocalDate.now();
    }

    public Post(String postId, String title, String message, String topicId) {
        super();
        this.postId = postId;
        this.title = title;
        this.message = message;
        this.topic = new Topic(topicId, "", "");
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String id) {
        this.postId = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
