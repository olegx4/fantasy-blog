package com.github.blog.post;

import com.github.blog.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topics")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/{topicId}/posts")
    public void addPost(@RequestBody Post post, @PathVariable Long topicId) {
        post.setTopic(new Topic(topicId, "", ""));
        postService.addPost(post);
    }
}
