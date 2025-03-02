package com.fellon.landmarkly.dtos;

import com.fellon.landmarkly.model.ServiceType;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Setter
@Getter
public class ServiceDto {
    private String name;
    private String description;
    private ServiceType serviceType;
}