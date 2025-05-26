package com.example.poolmanagement.controller;

import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please correct the errors in the form.");
            return "auth/login";
        }

        try {
            authService.register(user);
            model.addAttribute("success", "Registration successful for " + user.getUsername() + "!");
            return "auth/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "auth/login";
        }
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {
        String username = authentication.getName();
        System.out.println(username);
        User user = authService.findByUsername(username);
        model.addAttribute("user", user);
        return "auth/profile";
    }
<<<<<<< HEAD
    // adada
=======

>>>>>>> feature/nguyen
}