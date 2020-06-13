package com.github.blog.post.comment;

import com.github.blog.post.comment.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<CommentDto> getAll() {
        return commentsRepository
                .findAll()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }
}
