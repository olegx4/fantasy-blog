package com.github.blog.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}
