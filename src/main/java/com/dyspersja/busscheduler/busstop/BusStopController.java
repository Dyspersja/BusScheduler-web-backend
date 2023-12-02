package com.dyspersja.busscheduler.busstop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/bus_stops")
public class BusStopController {

    private final BusStopService service;

    @GetMapping
    public List<BusStop> getBusStops() {
        return service.getBusStops();
    }

    @GetMapping("/{id}")
    public BusStop getBusStops(@PathVariable int id) {
        return service.getBusStop(id);
    }
}
