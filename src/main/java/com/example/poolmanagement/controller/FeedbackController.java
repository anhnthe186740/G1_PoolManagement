package com.example.poolmanagement.controller;

import com.example.poolmanagement.dto.request.FeedbackRequest;
import com.example.poolmanagement.dto.response.FeedbackResponse;
import com.example.poolmanagement.service.feedback.FeedbackService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // API endpoints
    @PostMapping("/feedback")
    @ResponseBody
    public FeedbackResponse createFeedbackApi(@RequestBody @Valid FeedbackRequest request) {
        return feedbackService.createFeedback(request);
    }
}
