package com.github.blog.post.comment;

import com.github.blog.error.NotFoundException;
import com.github.blog.post.Post;
import com.github.blog.post.PostRepository;
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
                .findAllByIsDeletedFalse()
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    public CommentDto getById(Long id) {
        return commentsRepository.findByIdAndIsDeletedFalse(id)
                .map(CommentDto::new)
                .orElseThrow(() -> new NotFoundException("Comment with id " + id + " not found"));
    }

    @Transactional
    public CommentDto addComment(Long postId, CommentCommand command) {
        Post post = getPostById(postId);
        Comment comment = new Comment()
                .setText(command.getText())
                .setCreatedAt(command.getDateAndTime())
                .setPost(post);
        post.addComment(comment);
        return new CommentDto(commentsRepository.save(comment));
    }

    @Transactional
    public CommentDto updateComment(Long commentId, CommentUpdateCommand command) {
        return commentsRepository.findByIdAndIsDeletedFalse(commentId)
                .map(comment -> comment.setText(command.getText()))
                .map(CommentDto::new)
                .orElseThrow(() -> new NotFoundException("Comment with id " + commentId + " not found"));
    }

    @Transactional
    public void deleteComment(Long id) {
        commentsRepository.findByIdAndIsDeletedFalse(id)
                .ifPresentOrElse(commentsRepository::delete, () -> {
                    throw new NotFoundException(("Comment with id " + id + " not found"));
                });
    }

    @Transactional
    public void deletePostComments(Long postId) {
        Post post = getPostById(postId);
        List<Comment> comments = commentsRepository.findAllByPostIdAndIsDeletedFalse(postId)
                .orElseThrow(() -> new NotFoundException("Comments not found"));
        comments.forEach(post::removeComment);
    }

    private Post getPostById(Long postId) {
        return postRepository.findPostByIdAndIsDeletedFalse(postId)
                .orElseThrow(() -> new NotFoundException("Post with id " + postId + " not found"));
    }
}
