package com.fellon.landmarkly.controller;

import com.fellon.landmarkly.dtos.ServiceDto;
import com.fellon.landmarkly.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<ServiceDto> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping
    public ServiceDto createService(@RequestBody ServiceDto serviceDto) {
        return serviceService.createService(serviceDto);
    }

    @GetMapping("/{id}")
    public ServiceDto getServiceById(@PathVariable UUID id) {
        return serviceService.getServiceById(id);
    }

    @PutMapping("/{id}")
    public ServiceDto updateService(@PathVariable UUID id, @RequestBody ServiceDto serviceDto) {
        return serviceService.updateService(id, serviceDto);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable UUID id) {
        serviceService.deleteService(id);
    }
}
