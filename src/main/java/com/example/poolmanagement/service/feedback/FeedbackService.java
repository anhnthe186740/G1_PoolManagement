package com.example.poolmanagement.service.feedback;

import com.example.poolmanagement.dto.request.FeedbackRequest;
import com.example.poolmanagement.dto.response.FeedbackResponse;

public interface FeedbackService {
    FeedbackResponse createFeedback(FeedbackRequest request);
}
