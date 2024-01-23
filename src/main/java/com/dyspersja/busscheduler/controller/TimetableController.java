package com.dyspersja.busscheduler.controller;

import com.dyspersja.busscheduler.model.dto.TimetableDTO;
import com.dyspersja.busscheduler.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timetable")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService service;

    @GetMapping("/{lineId}")
    public ResponseEntity<TimetableDTO> getBusStopsByLineNumberAndReturnLine(
            @PathVariable Long lineId,
            @RequestParam(name = "stop") Long stopId
    ) {
        TimetableDTO timetable = service.getTimetableByLineAndBusStop(lineId, stopId);

        return ResponseEntity.ok(timetable);
    }
}
