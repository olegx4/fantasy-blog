package com.github.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/topics/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/topics/posts/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping("/topics/{topicId}/posts")
    public ResponseEntity<PostDto> addPost(@Valid @RequestBody PostCommand command) {
        return new ResponseEntity<>(postService.addPost(command), HttpStatus.CREATED);
    }

    @PutMapping("/topics/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostCommand command, @PathVariable Long id) {
        return ResponseEntity.ok(postService.updatePost(id, command));
    }

    @DeleteMapping("/topics/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
