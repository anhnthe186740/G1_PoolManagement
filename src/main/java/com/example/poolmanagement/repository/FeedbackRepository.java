package com.example.poolmanagement.repository;

import com.example.poolmanagement.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Optional<Feedback> findByUser_UserId(Integer userId);
}
