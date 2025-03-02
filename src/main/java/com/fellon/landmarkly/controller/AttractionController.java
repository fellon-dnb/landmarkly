package com.fellon.landmarkly.controller;

import com.fellon.landmarkly.dtos.AttractionDto;
import com.fellon.landmarkly.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<AttractionDto> getAllAttractions() {
        return attractionService.getAllAttractions();
    }

    @PostMapping
    public AttractionDto createAttraction(@RequestBody AttractionDto attractionDto) {
        return attractionService.createAttraction(attractionDto);
    }

    @GetMapping("/{id}")
    public AttractionDto getAttractionById(@PathVariable UUID id) {
        return attractionService.getAttractionById(id);
    }

    @PutMapping("/{id}")
    public AttractionDto updateAttraction(@PathVariable UUID id, @RequestBody AttractionDto attractionDto) {
        return attractionService.updateAttraction(id, attractionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable UUID id) {
        attractionService.deleteAttraction(id);
    }
}
