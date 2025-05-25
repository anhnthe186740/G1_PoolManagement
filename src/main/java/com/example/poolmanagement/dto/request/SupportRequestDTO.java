package com.example.poolmanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupportRequestDTO {
    @NotNull(message = "User ID is required")
    Integer userId;

    @NotBlank(message = "Support type cannot be empty")
    String supportType;

    @NotBlank(message = "Description cannot be empty")
    String description;

    String image1Path;
    String image2Path;

    @NotBlank(message = "Priority cannot be empty")
    String priority;
} 