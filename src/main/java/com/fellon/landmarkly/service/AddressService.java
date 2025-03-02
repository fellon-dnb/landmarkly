package com.fellon.landmarkly.service;

import com.fellon.landmarkly.model.Address;
import com.fellon.landmarkly.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
    public Optional<Address> getAddressById(String id) {
        return addressRepository.findById(id);
    }

}