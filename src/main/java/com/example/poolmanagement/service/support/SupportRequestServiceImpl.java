package com.example.poolmanagement.service.support;

import com.example.poolmanagement.dto.request.SupportRequestDTO;
import com.example.poolmanagement.dto.response.SupportRequestResponse;
import com.example.poolmanagement.entity.SupportRequest;
import com.example.poolmanagement.entity.User;
import com.example.poolmanagement.repository.SupportRequestRepository;
import com.example.poolmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SupportRequestServiceImpl implements SupportRequestService {
    private final SupportRequestRepository supportRequestRepository;
    private final UserRepository userRepository;

    public SupportRequestServiceImpl(SupportRequestRepository supportRequestRepository, UserRepository userRepository) {
        this.supportRequestRepository = supportRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SupportRequestResponse createSupportRequest(SupportRequestDTO request, MultipartFile image1File, MultipartFile image2File) {
        SupportRequest supportRequest = new SupportRequest();
        User user = new User();
        user.setUserId(request.getUserId());
        supportRequest.setUser(user);
        supportRequest.setSupportType(request.getSupportType());
        supportRequest.setDescription(request.getDescription());

        try {
            if (image1File != null && !image1File.isEmpty()) {
                String image1Path = saveFile(image1File);
                supportRequest.setImage1Path(image1Path);
            }
            if (image2File != null && !image2File.isEmpty()) {
                String image2Path = saveFile(image2File);
                supportRequest.setImage2Path(image2Path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save uploaded file(s)", e);
        }

        supportRequest.setPriority(request.getPriority());
        supportRequest.setSubmittedAt(LocalDateTime.now());
        supportRequest.setStatus("PENDING");

        SupportRequest savedRequest = supportRequestRepository.save(supportRequest);

        return SupportRequestResponse.builder()
                .requestId(savedRequest.getRequestId())
                .userId(savedRequest.getUser().getUserId())
                .userName(savedRequest.getUser().getUsername())
                .supportType(savedRequest.getSupportType())
                .description(savedRequest.getDescription())
                .image1Path(savedRequest.getImage1Path())
                .image2Path(savedRequest.getImage2Path())
                .priority(savedRequest.getPriority())
                .submittedAt(savedRequest.getSubmittedAt())
                .response(savedRequest.getResponse())
                .respondedAt(savedRequest.getRespondedAt())
                .status(savedRequest.getStatus())
                .build();
    }

    private String saveFile(MultipartFile file) throws IOException {
        String uploadDir = "uploads/";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);
        return filePath.toString();
    }
} 