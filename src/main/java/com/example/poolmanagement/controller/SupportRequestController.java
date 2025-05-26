package com.example.poolmanagement.controller;

import com.example.poolmanagement.dto.request.SupportRequestDTO;
import com.example.poolmanagement.dto.response.SupportRequestResponse;
import com.example.poolmanagement.service.support.SupportRequestService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api")
@Slf4j
public class SupportRequestController {
    private final SupportRequestService supportRequestService;
    /**
     * Inject SupportRequestService thông qua constructor.
     */

    public SupportRequestController(SupportRequestService supportRequestService) {
        this.supportRequestService = supportRequestService;
    }

    @PostMapping("/support")
    public String createSupportRequestApi(
            @ModelAttribute @Valid SupportRequestDTO request,
            @RequestParam(value = "image1File", required = false) MultipartFile image1File,
            @RequestParam(value = "image2File", required = false) MultipartFile image2File,
            RedirectAttributes redirectAttributes) {

        try {
            supportRequestService.createSupportRequest(request, image1File, image2File);
            redirectAttributes.addFlashAttribute("successMessage", "Your support request has been submitted successfully!");
        } catch (RuntimeException e) { // Catch potential exceptions from the service layer
            log.error("Error submitting support request", e);
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to submit support request. " + e.getMessage());
        }

        return "redirect:/support";
    }
} 