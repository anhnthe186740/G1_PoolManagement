package com.example.poolmanagement.controller;

import com.example.poolmanagement.dto.request.FeedbackRequest;
import com.example.poolmanagement.dto.response.FeedbackResponse;
import com.example.poolmanagement.service.feedback.FeedbackService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api")
@Slf4j
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedback")
    public String createFeedbackApi(@ModelAttribute @Valid FeedbackRequest request, RedirectAttributes redirectAttributes) {
        feedbackService.createFeedback(request);
        redirectAttributes.addFlashAttribute("successMessage", "Your feedback has been submitted successfully!");
        return "redirect:/feedback";
    }
}
