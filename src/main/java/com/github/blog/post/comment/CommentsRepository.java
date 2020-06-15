package com.github.blog.post.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByIdAndIsDeletedFalse(Long id);

    List<Comment> findAllByIsDeletedFalse();

    Optional<List<Comment>> findAllByPostIdAndIsDeletedFalse(Long id);
}
