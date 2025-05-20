package com.example.poolmanagement.entity;

import com.example.poolmanagement.enums.AppEnums;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "swim_packages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SwimPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Integer packageId;

    @NotNull
    @Size(max = 100)
    @Column(name = "package_name")
    private String packageName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "total_sessions")
    private Integer totalSessions;

    @Column(name = "duration_days")
    private Integer durationDays;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private User coach;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppEnums.SwimPackageStatus status = AppEnums.SwimPackageStatus.Active;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}