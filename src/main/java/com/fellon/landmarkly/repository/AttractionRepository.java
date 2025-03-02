package com.fellon.landmarkly.repository;

import com.fellon.landmarkly.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    List<Attraction> findByNameContaining(String name);

}
