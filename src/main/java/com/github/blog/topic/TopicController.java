package com.github.blog.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<TopicDto> addTopic(@Valid @RequestBody TopicCommand command) {
        return new ResponseEntity<>(topicService.addTopic(command), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> updateTopic(@Valid @RequestBody TopicCommand command, @PathVariable Long id) {
        return ResponseEntity.ok(topicService.updateTopic(id, command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
