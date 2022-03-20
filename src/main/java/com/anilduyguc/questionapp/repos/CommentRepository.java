package com.anilduyguc.questionapp.repos;

import com.anilduyguc.questionapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
