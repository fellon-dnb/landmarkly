package com.fellon.landmarkly.controller;

import com.fellon.landmarkly.model.Attraction;
import com.fellon.landmarkly.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public List<Attraction> getAllAttractions() {
        return attractionService.getAllAttractions();
    }

    @PostMapping
    public Attraction createAttraction(@RequestBody Attraction attraction) {
        return attractionService.createAttraction(attraction);
    }
@GetMapping("/search")
    public List<Attraction> searchAttractionsByNames(@RequestParam String name) {
        return attractionService.searchAttractionsByName(name);
    }
}
