package com.github.blog.picture;

import java.time.Instant;

public class Picture {

    private Long id;
    private String name;
    private String description;
    private String pictureUrl;
    private Instant uploadedDate;

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Picture setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Picture setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public Instant getUploadedDate() {
        return uploadedDate;
    }

    public Picture setUploadedDate(Instant uploadedDate) {
        this.uploadedDate = uploadedDate;
        return this;
    }
}
