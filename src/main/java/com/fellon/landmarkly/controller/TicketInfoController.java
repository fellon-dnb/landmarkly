package com.fellon.landmarkly.controller;

import com.fellon.landmarkly.dtos.TicketInfoDto;
import com.fellon.landmarkly.service.TicketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ticketinfo")
public class TicketInfoController {

    private final TicketInfoService ticketInfoService;

    @Autowired
    public TicketInfoController(TicketInfoService ticketInfoService) {
        this.ticketInfoService = ticketInfoService;
    }

    @PostMapping
    public TicketInfoDto createTicketInfo(@RequestBody TicketInfoDto ticketInfoDto) {
        return ticketInfoService.createTicketInfo(ticketInfoDto);
    }

    @GetMapping("/{id}")
    public TicketInfoDto getTicketInfoById(@PathVariable UUID id) {
        return ticketInfoService.getTicketInfoById(id);
    }

    @PutMapping("/{id}")
    public TicketInfoDto updateTicketInfo(@PathVariable UUID id, @RequestBody TicketInfoDto ticketInfoDto) {
        return ticketInfoService.updateTicketInfo(id, ticketInfoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTicketInfo(@PathVariable UUID id) {
        ticketInfoService.deleteTicketInfo(id);
    }
}
