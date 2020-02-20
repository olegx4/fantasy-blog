package com.github.olegx4.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private final List<Topic> topics = Arrays.asList(
            new Topic("spring", "Spring Boot", "Spring Boot Description"),
            new Topic("java", "Java 8", "Java 8 Description"),
            new Topic("csharp", "C#", "C# Description")
    );

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse( null );
    }
}
