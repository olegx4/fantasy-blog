package com.github.blog.post;

import com.github.blog.error.NotFoundException;
import com.github.blog.topic.Topic;
import com.github.blog.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public PostService(PostRepository postRepository, TopicRepository topicRepository) {
        this.postRepository = postRepository;
        this.topicRepository = topicRepository;
    }

    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .filter(post -> isFalse(post.getDeleted()))
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public PostDto addPost(PostCommand command) {
        Post post = new Post(command);
        post.setTopic(getTopicById(command.getTopicId()));
        return new PostDto(postRepository.save(post));
    }

    private Topic getTopicById(Long id) {
        return topicRepository
                .findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Topic with id " + id + " not found"));
    }

    public PostDto getPostById(Long id) {
        return postRepository
                .findPostByIdAndIsDeletedFalse(id)
                .map(PostDto::new)
                .orElseThrow(() -> new NotFoundException("Post with id " + id + " not found"));
    }

    public void deletePost(Long id) {
        postRepository.findPostByIdAndIsDeletedFalse(id)
                .ifPresentOrElse(post -> post.setDeleted(true), () -> {
                    throw new NotFoundException("Post with ID " + id + " not found");
                });
    }

    public PostDto updatePost(Long id, PostCommand command) {
        return new PostDto(postRepository
                .findPostByIdAndIsDeletedFalse(id)
                .map(post -> updateTargetPost(command, post))
                .orElseThrow(() -> new NotFoundException("Post with ID " + id + " not found")));
    }

    private Post updateTargetPost(PostCommand command, Post targetPost) {
        targetPost.setTitle(command.getTitle());
        targetPost.setMessage(command.getMessage());
        targetPost.setAttachment(command.getAttachment());
        targetPost.setDateAndTime(command.getDateAndTime());
        targetPost.setTopic(getTopicById(command.getTopicId()));
        return targetPost;
    }
}
