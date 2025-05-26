package com.example.poolmanagement.service;

import com.example.poolmanagement.entity.Role;
import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.repository.RoleRepository;
import com.example.poolmanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
<<<<<<< HEAD
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // "google", "github"
=======
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
>>>>>>> feature/nguyen
        OAuth2User oauthUser = super.loadUser(userRequest);
        Map<String, Object> attributes = oauthUser.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String username = email;

        if ("github".equals(registrationId)) {
            username = (String) attributes.get("login");
            if (name == null) name = username;
        }

<<<<<<< HEAD
        // Check user đã tồn tại chưa
=======

>>>>>>> feature/nguyen
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setName(name != null ? name : "No Name");
<<<<<<< HEAD
            newUser.setPassword(null); // Không dùng mật khẩu
=======
            newUser.setPassword(null);
>>>>>>> feature/nguyen
            newUser.setPhoneNumber(null);
            newUser.setGender(null);
            newUser.setDateOfBirth(null);
            newUser.setHireDate(LocalDate.now());
            newUser.setCreatedAt(LocalDateTime.now());
            newUser.setStatus("ACTIVE");

            Role role = roleRepository.findByRoleName("USER")
                    .orElseThrow(() -> new RuntimeException("Role USER not found"));
            newUser.setRole(role);

            userRepository.save(newUser);
<<<<<<< HEAD
        } else {
            // Nếu tồn tại rồi, có thể cập nhật tên
=======

        } else {
           
>>>>>>> feature/nguyen
            User user = existingUser.get();
            user.setName(name);
            userRepository.save(user);
        }

        Role role = existingUser.map(User::getRole).orElseGet(() ->
                roleRepository.findByRoleName("USER").orElse(null));

        return new DefaultOAuth2User(
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + (role != null ? role.getRoleName() : "USER"))),
                oauthUser.getAttributes(),
                registrationId.equals("github") ? "login" : "email"
        );
<<<<<<< HEAD
        // Trả về DefaultOAuth2User với authorities và attributes
=======
>>>>>>> feature/nguyen
    }
}
