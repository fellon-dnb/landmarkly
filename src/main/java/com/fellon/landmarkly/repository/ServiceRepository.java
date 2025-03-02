package com.fellon.landmarkly.repository;

import com.fellon.landmarkly.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
