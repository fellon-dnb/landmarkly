package com.fellon.landmarkly.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
 private Integer building;
 private String street;
    private String city;
    private String region;
    private Double longitude;
    private Double latitude;
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL); // один адрес - много мест
    private List<Atraction> landmarks;
}
