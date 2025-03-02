package com.fellon.landmarkly.service;

import com.fellon.landmarkly.model.Attraction;
import com.fellon.landmarkly.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {
    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Attraction createAttraction(Attraction attraction) {
        return attractionRepository.save(attraction);
    }
    public List<Attraction> searchAttractionsByName(String name) {
        return attractionRepository.findByNameContaining(name);
    }
}
