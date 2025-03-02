package com.fellon.landmarkly.service;

import com.fellon.landmarkly.dtos.ServiceDto;
import com.fellon.landmarkly.mappers.ServiceMapper;
import com.fellon.landmarkly.model.ServiceEntity;
import com.fellon.landmarkly.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceDto> getAllServices() {
        List<ServiceEntity> services = serviceRepository.findAll();
        return serviceMapper.toDtoList(services);
    }

    public ServiceDto createService(ServiceDto serviceDto) {
        ServiceEntity serviceEntity = serviceMapper.toEntity(serviceDto);
        ServiceEntity savedService = serviceRepository.save(serviceEntity);
        return serviceMapper.toDto(savedService);
    }

    public ServiceDto getServiceById(UUID id) {
        Optional<ServiceEntity> service = serviceRepository.findById(id);
        return service.map(serviceMapper::toDto).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public ServiceDto updateService(UUID id, ServiceDto serviceDto) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not found");
        }
        ServiceEntity serviceEntity = serviceMapper.toEntity(serviceDto);
        serviceEntity.setId(id);
        ServiceEntity updatedService = serviceRepository.save(serviceEntity);
        return serviceMapper.toDto(updatedService);
    }

    public void deleteService(UUID id) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not found");
        }
        serviceRepository.deleteById(id);
    }
}
