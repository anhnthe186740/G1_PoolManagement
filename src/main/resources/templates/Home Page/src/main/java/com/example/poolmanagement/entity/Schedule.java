package com.example.poolmanagement.entity;

import com.example.poolmanagement.enums.AppEnums;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @NotNull
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @NotNull
    @Column(name = "max_tickets")
    private Integer maxTickets;

    @NotNull
    @Column(name = "adult_price")
    private BigDecimal adultPrice;

    @NotNull
    @Column(name = "child_price")
    private BigDecimal childPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppEnums.ScheduleStatus status = AppEnums.ScheduleStatus.Open;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}