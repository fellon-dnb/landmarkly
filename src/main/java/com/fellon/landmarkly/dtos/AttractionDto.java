package com.fellon.landmarkly.dtos;

import com.fellon.landmarkly.model.AttractionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionDto {
    private String name;
    private String description;
    private AttractionType attractionType;

}
