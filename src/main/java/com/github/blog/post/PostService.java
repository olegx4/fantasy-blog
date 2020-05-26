package com.github.blog.post;

import com.github.blog.error.NotFoundException;
import com.github.blog.post.dto.PostDto;
import com.github.blog.post.dto.command.PostCommand;
import com.github.blog.topic.Topic;
import com.github.blog.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public PostDto addPost(PostCommand command) {
        Post post = new Post();
        Topic topic = topicRepository
                .findByIdAndIsDeletedFalse(command.getTopicId())
                .orElseThrow(() -> new NotFoundException("Topic with id " + command.getTopicId() + " not found"));
        post.setAttachment(command.getAttachment());
        post.setDateAndTime(command.getDateAndTime());
        post.setMessage(command.getMessage());
        post.setTitle(command.getTitle());
        post.setTopic(topic);
        return new PostDto(postRepository.save(post));
    }
}
