package com.fellon.landmarkly.mappers;

import com.fellon.landmarkly.dtos.AttractionDto;
import com.fellon.landmarkly.model.Attraction;
import com.fellon.landmarkly.model.AttractionType;
import org.springframework.stereotype.Component;

@Component
public class AttractionMapper {

    public AttractionDto toDto(Attraction attraction) {
        AttractionDto dto = new AttractionDto();
        dto.setName(attraction.getName());
        dto.setDescription(attraction.getDescription());
        dto.setAttractionType(attraction.getAttractionType().name());
        return dto;
    }

    public Attraction toEntity(AttractionDto dto) {
        Attraction attraction = new Attraction();
        attraction.setName(dto.getName());
        attraction.setDescription(dto.getDescription());
        attraction.setAttractionType(AttractionType.valueOf(dto.getAttractionType()));
        return attraction;
    }
}
