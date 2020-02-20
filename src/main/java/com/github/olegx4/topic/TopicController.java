package com.github.olegx4.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("spring", "Spring Boot", "Spring Boot Description"),
                new Topic("java", "Java 8", "Java 8 Description"),
                new Topic("c#", "C#", "C# Description")
                );
    }
}
