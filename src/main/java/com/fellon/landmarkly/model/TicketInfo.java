package com.fellon.landmarkly.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ticket_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketInfo {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Boolean availability;

    @OneToOne
    @JoinColumn(name = "attraction_id", nullable = false, unique = true)
    private Attraction attraction;
}
