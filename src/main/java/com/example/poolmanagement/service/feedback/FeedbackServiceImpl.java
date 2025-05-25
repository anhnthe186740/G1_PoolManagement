package com.example.poolmanagement.service.feedback;

import com.example.poolmanagement.dto.request.FeedbackRequest;
import com.example.poolmanagement.dto.response.FeedbackResponse;
import com.example.poolmanagement.entity.Feedback;
import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.exception.BadRequestException;
import com.example.poolmanagement.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public FeedbackResponse createFeedback(FeedbackRequest request) {
        if (request.getRating() < 1 || request.getRating() > 5) {
            throw new BadRequestException("Rating must be between 1 and 5");
        }

        Feedback feedback = new Feedback();
        User user = new User();
        user.setUserId(request.getUserId());
        feedback.setUser(user);
        feedback.setContent(request.getContent());
        feedback.setRating(request.getRating());
        feedback.setSubmittedAt(LocalDateTime.now());
        feedback.setStatus("PENDING");

        Feedback savedFeedback = feedbackRepository.save(feedback);

        return FeedbackResponse.builder()
                .feedbackId(savedFeedback.getFeedbackId())
                .userId(savedFeedback.getUser().getUserId())
                .userName(savedFeedback.getUser().getUsername())
                .content(savedFeedback.getContent())
                .rating(savedFeedback.getRating())
                .submittedAt(savedFeedback.getSubmittedAt())
                .response(savedFeedback.getResponse())
                .respondedAt(savedFeedback.getRespondedAt())
                .status(savedFeedback.getStatus())
                .build();
    }
}
