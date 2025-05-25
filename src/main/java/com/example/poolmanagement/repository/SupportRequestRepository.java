package com.example.poolmanagement.repository;

import com.example.poolmanagement.entity.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupportRequestRepository extends JpaRepository<SupportRequest, Long> {
    Optional<SupportRequest> findByUser_UserId(Integer userId);
} 