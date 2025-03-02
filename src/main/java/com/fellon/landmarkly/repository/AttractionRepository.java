package com.fellon.landmarkly.repository;

import com.fellon.landmarkly.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, UUID> {
}
