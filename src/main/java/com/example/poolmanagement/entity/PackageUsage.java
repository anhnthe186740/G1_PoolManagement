package com.example.poolmanagement.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "package_usages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usage_id")
    private Integer usageId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private PackageSubscription subscription;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Column(name = "usage_date")
    private LocalDateTime usageDate = LocalDateTime.now();

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}