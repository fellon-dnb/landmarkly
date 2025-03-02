package com.fellon.landmarkly.service;

import com.fellon.landmarkly.dtos.TicketInfoDto;
import com.fellon.landmarkly.mappers.TicketInfoMapper;
import com.fellon.landmarkly.model.Attraction;
import com.fellon.landmarkly.model.TicketInfo;
import com.fellon.landmarkly.repository.TicketInfoRepository;
import com.fellon.landmarkly.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketInfoService {

    private final TicketInfoRepository ticketInfoRepository;
    private final TicketInfoMapper ticketInfoMapper;
    private final AttractionRepository attractionRepository; // для установки связи

    @Autowired
    public TicketInfoService(TicketInfoRepository ticketInfoRepository,
                             TicketInfoMapper ticketInfoMapper,
                             AttractionRepository attractionRepository) {
        this.ticketInfoRepository = ticketInfoRepository;
        this.ticketInfoMapper = ticketInfoMapper;
        this.attractionRepository = attractionRepository;
    }

    public TicketInfoDto createTicketInfo(TicketInfoDto ticketInfoDto) {
        TicketInfo ticketInfo = ticketInfoMapper.toEntity(ticketInfoDto);
        // Устанавливаем связь с Attraction по переданному идентификатору
        Attraction attraction = attractionRepository.findById(ticketInfoDto.getAttractionId())
                .orElseThrow(() -> new RuntimeException("Attraction not found"));
        ticketInfo.setAttraction(attraction);

        TicketInfo savedTicketInfo = ticketInfoRepository.save(ticketInfo);
        return ticketInfoMapper.toDto(savedTicketInfo);
    }

    public TicketInfoDto getTicketInfoById(UUID id) {
        TicketInfo ticketInfo = ticketInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TicketInfo not found"));
        return ticketInfoMapper.toDto(ticketInfo);
    }

    public TicketInfoDto updateTicketInfo(UUID id, TicketInfoDto ticketInfoDto) {
        if (!ticketInfoRepository.existsById(id)) {
            throw new RuntimeException("TicketInfo not found");
        }
        TicketInfo ticketInfo = ticketInfoMapper.toEntity(ticketInfoDto);
        ticketInfo.setId(id);
        // Обновляем связь, если передан новый attractionId
        Attraction attraction = attractionRepository.findById(ticketInfoDto.getAttractionId())
                .orElseThrow(() -> new RuntimeException("Attraction not found"));
        ticketInfo.setAttraction(attraction);

        TicketInfo updatedTicketInfo = ticketInfoRepository.save(ticketInfo);
        return ticketInfoMapper.toDto(updatedTicketInfo);
    }

    public void deleteTicketInfo(UUID id) {
        if (!ticketInfoRepository.existsById(id)) {
            throw new RuntimeException("TicketInfo not found");
        }
        ticketInfoRepository.deleteById(id);
    }
}
