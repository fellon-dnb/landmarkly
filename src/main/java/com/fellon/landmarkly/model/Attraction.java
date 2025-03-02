package com.fellon.landmarkly.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AllArgsConstructor
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


}
