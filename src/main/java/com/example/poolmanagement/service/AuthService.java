package com.example.poolmanagement.service;

import com.example.poolmanagement.entity.Role;
import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.repository.RoleRepository;
import com.example.poolmanagement.repository.UserRepository;
<<<<<<< HEAD

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

=======
>>>>>>> feature/nguyen
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class AuthService {
=======
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {

>>>>>>> feature/nguyen
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(User request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username is already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already in use");
        }
        
        User user = new User();
        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setGender(request.getGender());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setHireDate(LocalDate.now());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = roleRepository.findByRoleName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus("ACTIVE");

        userRepository.save(user);

        return user;
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

<<<<<<< HEAD
=======
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

>>>>>>> feature/nguyen
    public User login(User request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        } else {
            request.setEmail(user.get().getEmail());
        }

        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority().substring(5); // Bỏ "ROLE_"

        return request;
    }
<<<<<<< HEAD
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }
=======
>>>>>>> feature/nguyen
}