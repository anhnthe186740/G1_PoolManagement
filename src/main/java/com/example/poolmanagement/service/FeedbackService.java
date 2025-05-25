package com.example.poolmanagement.service;

import com.example.poolmanagement.entity.Feedback;
import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();
}