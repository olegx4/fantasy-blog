package com.github.olegx4.post;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, String> {
    List<Post> findByTopicId(String topicId);
}
