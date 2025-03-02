package com.fellon.landmarkly.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Setter
@Getter
public class AddressDto {
    private UUID id;
    private Integer building;
    private String street;
    private String city;
    private String region;
    private Double longitude;
    private Double latitude;


}
