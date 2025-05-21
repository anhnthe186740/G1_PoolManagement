package com.example.poolmanagement.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "swim_classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SwimClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private User coach;

    @NotNull
    @Column(name = "max_students")
    private Integer maxStudents;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @Column(name = "status")
    private String status ;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
