package com.example.poolmanagement.entity;

import com.example.poolmanagement.enums.AppEnums;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "support_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupportRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "support_type")
    private AppEnums.SupportType supportType;

    @NotNull
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Size(max = 255)
    @Column(name = "image1_path")
    private String image1Path;

    @Size(max = 255)
    @Column(name = "image2_path")
    private String image2Path;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private AppEnums.Priority priority = AppEnums.Priority.Medium;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column(name = "response", columnDefinition = "TEXT")
    private String response;

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppEnums.FeedbackStatus status = AppEnums.FeedbackStatus.Pending;
}
