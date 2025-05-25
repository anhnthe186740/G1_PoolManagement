package com.example.poolmanagement.service.support;

import com.example.poolmanagement.dto.request.SupportRequestDTO;
import com.example.poolmanagement.dto.response.SupportRequestResponse;
import org.springframework.web.multipart.MultipartFile;

public interface SupportRequestService {
    SupportRequestResponse createSupportRequest(SupportRequestDTO request, MultipartFile image1File, MultipartFile image2File);
} 