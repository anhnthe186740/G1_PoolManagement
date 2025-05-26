package com.example.poolmanagement.service;

import com.example.poolmanagement.controller.UserApiController.UserProfileUpdateDto;
import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (username == null || username.equals("anonymousUser")) {
            throw new RuntimeException("No authenticated user found");
        }
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }

    // Method cập nhật profile nhận DTO từ controller
    public User updateUserProfile(UserProfileUpdateDto dto) {
        User existingUser = getCurrentUser();

        // Optional: kiểm tra userId trong dto có trùng với currentUser không để an toàn
        if (!existingUser.getUserId().equals(dto.getUserId())) {
            throw new RuntimeException("User ID mismatch");
        }

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPhoneNumber(dto.getPhoneNumber());
        existingUser.setGender(dto.getGender());
        existingUser.setDateOfBirth(dto.getDateOfBirth());

        return userRepository.save(existingUser);
    }
}
