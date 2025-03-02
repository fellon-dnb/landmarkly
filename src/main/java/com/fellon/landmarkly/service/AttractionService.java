package com.fellon.landmarkly.service;

import com.fellon.landmarkly.dtos.AttractionDto;
import com.fellon.landmarkly.mappers.AttractionMapper;
import com.fellon.landmarkly.model.Attraction;
import com.fellon.landmarkly.repository.AttractionRepository;
import com.fellon.landmarkly.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository, AttractionMapper attractionMapper) {
        this.attractionRepository = attractionRepository;
        this.attractionMapper = attractionMapper;
    }

    public List<AttractionDto> getAllAttractions() {
        List<Attraction> attractions = attractionRepository.findAll();
        return attractionMapper.toDtoList(attractions);
    }

    public AttractionDto createAttraction(AttractionDto attractionDto) {
        Attraction attraction = attractionMapper.toEntity(attractionDto);
        Attraction savedAttraction = attractionRepository.save(attraction);
        return attractionMapper.toDto(savedAttraction);
    }

    public AttractionDto getAttractionById(UUID id) {
        Optional<Attraction> attraction = attractionRepository.findById(id);
        return attraction.map(attractionMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Attraction not found"));
    }

    public AttractionDto updateAttraction(UUID id, AttractionDto attractionDto) {
        if (!attractionRepository.existsById(id)) {
            throw new EntityNotFoundException("Attraction not found");
        }
        Attraction attraction = attractionMapper.toEntity(attractionDto);
        attraction.setId(id);
        Attraction updatedAttraction = attractionRepository.save(attraction);
        return attractionMapper.toDto(updatedAttraction);
    }

    public void deleteAttraction(UUID id) {
        if (!attractionRepository.existsById(id)) {
            throw new EntityNotFoundException("Attraction not found");
        }
        attractionRepository.deleteById(id);
    }
}
