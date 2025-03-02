package com.fellon.landmarkly.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "services")
public class ServiceEntity {  // <-- Было Service, стало ServiceEntity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
}
