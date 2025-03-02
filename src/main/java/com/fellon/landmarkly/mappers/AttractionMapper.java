package com.fellon.landmarkly.mappers;

import com.fellon.landmarkly.dtos.AttractionDto;
import com.fellon.landmarkly.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttractionMapper {

    AttractionMapper INSTANCE = Mappers.getMapper(AttractionMapper.class);

    AttractionDto toDto(Attraction attraction);
    Attraction toEntity(AttractionDto attractionDto);

    List<AttractionDto> toDtoList(List<Attraction> attractions);
}
