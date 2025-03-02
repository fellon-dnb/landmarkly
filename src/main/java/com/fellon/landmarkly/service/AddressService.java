package com.fellon.landmarkly.service;

import com.fellon.landmarkly.model.Address;
import com.fellon.landmarkly.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressById(UUID id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public Address updateAddress(UUID id, Address address) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }
        address.setId(id);
        return addressRepository.save(address);
    }

    public void deleteAddress(UUID id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
