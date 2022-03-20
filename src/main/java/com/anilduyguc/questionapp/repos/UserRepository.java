package com.anilduyguc.questionapp.repos;

import com.anilduyguc.questionapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
