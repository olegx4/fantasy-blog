package com.github.blog.topic;

import com.github.blog.error.NotFoundException;
import com.github.blog.topic.dto.TopicDto;
import com.github.blog.topic.dto.command.TopicCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Service
@Transactional
public class TopicService {

    private final TopicRepository topicRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public TopicService(TopicRepository topicRepository, JavaMailSender javaMailSender) {
        this.topicRepository = topicRepository;
        this.javaMailSender = javaMailSender;
    }

    public List<TopicDto> getAllTopics() {
        return topicRepository
                .findAll()
                .stream()
                .filter(topic -> isFalse(topic.getDeleted()))
                .map(TopicDto::new)
                .collect(Collectors.toList());
    }

    public TopicDto getTopicById(Long id) {
        return topicRepository
                .findById(id)
                .map(TopicDto::new)
                .orElseThrow(() -> new NotFoundException("Topic with ID " + id + " not found"));
    }

    public TopicDto addTopic(TopicCommand command) {
        Topic topic = commandToTopic(command);
        sendEmail(topic.getName());
        return new TopicDto(topicRepository.save(topic));
    }

    public TopicDto updateTopic(Long id, TopicCommand command) {
        return new TopicDto(topicRepository
                .findByIdAndIsDeletedFalse(id)
                .map(topic -> updateTargetTopic(command, topic))
                .orElseThrow(() -> new NotFoundException("Topic with ID " + id + " not found")));
    }

    public void deleteTopic(Long id) {
        topicRepository.findByIdAndIsDeletedFalse(id)
                .ifPresentOrElse(topic -> topic.setDeleted(true), () -> {
                    throw new NotFoundException("Topic with ID " + id + " not found");
                });
    }

    private Topic updateTargetTopic(TopicCommand command, Topic targetTopic) {
        targetTopic.setName(command.getName());
        targetTopic.setDescription(command.getDescription());
        return targetTopic;
    }

    private Topic commandToTopic(TopicCommand command) {
        Topic topic = new Topic();
        topic.setName(command.getName());
        topic.setDescription(command.getDescription());
        return topic;
    }

    void sendEmail(String topicName) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("olegx4@ukr.net");
        msg.setSubject("New topic created");
        msg.setText("Topic \"" + topicName + "\" created.");

        javaMailSender.send(msg);
    }
}
