package com.github.blog.topic;

import com.github.blog.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<TopicDto> getAllTopics() {
        return topicRepository
                .findAll()
                .stream()
                .map(TopicDto::new)
                .collect(Collectors.toList());
    }

    public TopicDto getTopicById(Long id) {
        return topicRepository
                .findById(id)
                .map(TopicDto::new)
                .orElseThrow(() -> new NotFoundException("Topic with ID " + id + " not found"));
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Long id, Topic topic) {
        if (topicRepository.existsById(id)) {
            topicRepository.save(topic);
        }
    }

    public void deleteTopic(Long id) {
        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
        }
    }
}
