package com.dyspersja.busscheduler.controller;

import com.dyspersja.busscheduler.model.dto.BusLineDetailsDTO;
import com.dyspersja.busscheduler.service.BusLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bus_lines")
@RequiredArgsConstructor
public class BusLineController {

    private final BusLineService service;

    @GetMapping
    public ResponseEntity<List<BusLineDetailsDTO>> getAllBusLinesDetails() {
        List<BusLineDetailsDTO> busLines = service.getDetailedBusLines();

        return busLines.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(busLines);
    }
}
