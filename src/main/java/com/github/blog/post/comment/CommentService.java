package com.github.blog.post.comment;

import com.github.blog.error.NotFoundException;
import com.github.blog.post.Post;
import com.github.blog.post.PostRepository;
import com.github.blog.post.comment.dto.CommentDto;
import com.github.blog.post.comment.dto.command.CommentCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentsRepository commentsRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository, PostRepository postRepository) {
        this.commentsRepository = commentsRepository;
        this.postRepository = postRepository;
    }

    public List<CommentDto> getAll() {
        return commentsRepository
                .findAll()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto addComment(Long postId, CommentCommand command) {
        Post post = postRepository
                .findPostByIdAndIsDeletedFalse(postId)
                .orElseThrow(() -> new NotFoundException("Post with id " + postId + " not found"));
        Comment comment = new Comment()
                .setText(command.getText())
                .setCreatedAt(command.getDateAndTime())
                .setPost(post);
        post.addComment(comment);
        return new CommentDto(comment);
    }
}
