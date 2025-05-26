package com.example.poolmanagement.controller;

import com.example.poolmanagement.entity.Feedback;
import com.example.poolmanagement.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/admin/feedback/list")
    public String viewFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "feedback/list";
    }
}