package com.fellon.landmarkly.controller;

import com.fellon.landmarkly.model.Address;
import com.fellon.landmarkly.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
public class AddressController {
private final AddressService addressService;
@Autowired
public AddressController(AddressService addressService) {
this.addressService = addressService;
}
@PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
        @GetMapping("/{id}")
                public Optional<Address> getAddressById(@PathVariable UUID id) {
                    return addressService.getAddressById(id);
                }
    }
}

