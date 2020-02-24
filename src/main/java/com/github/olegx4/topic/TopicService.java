package com.github.olegx4.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Boot", "Spring Boot Description"),
            new Topic("java", "Java 8", "Java 8 Description"),
            new Topic("csharp", "C#", "C# Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }


    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
