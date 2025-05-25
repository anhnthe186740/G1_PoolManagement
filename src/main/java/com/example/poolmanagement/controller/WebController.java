package com.example.poolmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.poolmanagement.repository.UserRepository;
import java.util.List;
import com.example.poolmanagement.entity.User;

@Controller
public class WebController {

    private final UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/feedback")
    public String showFeedbackPage(Model model) {
        List<User> users = userRepository.findByRole_RoleName("USER");
        model.addAttribute("users", users);
        return "feedback";
    }

    @GetMapping("/support")
    public String showSupportPage(Model model) {
        List<User> users = userRepository.findByRole_RoleName("USER");
        model.addAttribute("users", users);
        return "support";
    }
} 