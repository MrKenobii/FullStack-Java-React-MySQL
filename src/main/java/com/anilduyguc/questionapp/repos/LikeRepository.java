package com.anilduyguc.questionapp.repos;

import com.anilduyguc.questionapp.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
