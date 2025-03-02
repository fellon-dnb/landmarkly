package com.fellon.landmarkly.repository;

import com.fellon.landmarkly.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}