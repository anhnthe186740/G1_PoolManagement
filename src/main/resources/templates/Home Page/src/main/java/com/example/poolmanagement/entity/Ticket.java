package com.example.poolmanagement.entity;

import com.example.poolmanagement.enums.AppEnums;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type")
    private AppEnums.TicketType ticketType;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @Size(max = 50)
    @Column(name = "ticket_code", unique = true)
    private String ticketCode;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppEnums.TicketStatus status = AppEnums.TicketStatus.Unused;
}