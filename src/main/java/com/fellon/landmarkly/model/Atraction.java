package com.fellon.landmarkly.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Atraction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    // Связь с Address
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    // Связь с Service (многие ко многим)
    @ManyToMany
    private List<Service> services;

    // Связь с TicketInfo (один к одному)
    @OneToOne(mappedBy = "attraction")
    private TicketInfo ticketInfo;
}
