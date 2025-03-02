package com.fellon.landmarkly.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketInfoDto {
    private UUID id;
    private BigDecimal price;
    private String currency;
    private Boolean availability;
    private UUID attractionId; // Идентификатор достопримечательности, к которой привязан билет
}
