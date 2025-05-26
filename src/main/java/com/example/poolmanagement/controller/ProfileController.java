package com.example.poolmanagement.controller;

import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/editprofile")
    public String showEditProfileForm(Model model) {
        try {
            User user = userService.getCurrentUser();
            model.addAttribute("user", user);
            return "admin/editprofile";  // Sửa lại đường dẫn template ở đây
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
