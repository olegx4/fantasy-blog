package com.github.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(String topicId) {
        return new ArrayList<>(postRepository.findByTopicId(topicId));
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }
}
