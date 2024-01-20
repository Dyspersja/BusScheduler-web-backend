package com.dyspersja.busscheduler.controller;

import com.dyspersja.busscheduler.model.dto.BusStopBriefDTO;
import com.dyspersja.busscheduler.service.BusStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus_stops")
@RequiredArgsConstructor
public class BusStopController {

    private final BusStopService service;

    @GetMapping("/{lineNumber}")
    public ResponseEntity<List<BusStopBriefDTO>> getBusStopsByLineNumberAndReturnLine(
            @PathVariable int lineNumber,
            @RequestParam(name = "r", defaultValue = "false") boolean isReturn
    ) {
        List<BusStopBriefDTO> busStops =
                service.getBusStopsByLineNumberAndReturnLine(lineNumber, isReturn);

        return busStops.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(busStops);
    }
}
