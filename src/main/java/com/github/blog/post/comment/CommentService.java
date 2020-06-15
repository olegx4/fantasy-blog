package com.github.blog.post.comment;

import com.github.blog.error.NotFoundException;
import com.github.blog.post.Post;
import com.github.blog.post.PostRepository;
import com.github.blog.post.comment.dto.CommentDto;
import com.github.blog.post.comment.dto.command.CommentCommand;
import com.github.blog.post.comment.dto.command.CommentUpdateCommand;
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
        return new CommentDto(commentsRepository.save(comment));
    }

    @Transactional
    public CommentDto updateComment(Long commentId, CommentUpdateCommand command) {
        return commentsRepository.findById(commentId)
                .map(comment -> comment.setText(command.getText()))
                .map(CommentDto::new)
                .orElseThrow(() -> new NotFoundException("Comment with id " + commentId + " not found"));
    }
}
